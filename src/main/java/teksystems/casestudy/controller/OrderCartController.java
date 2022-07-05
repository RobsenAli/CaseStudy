package teksystems.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.dao.OrderDAO;
import teksystems.casestudy.database.dao.OrderProductDAO;
import teksystems.casestudy.database.dao.ProductDAO;
import teksystems.casestudy.database.dao.UserDAO;
import teksystems.casestudy.database.entity.Order;
import teksystems.casestudy.database.entity.OrderProduct;
import teksystems.casestudy.database.entity.User;
import teksystems.casestudy.formbean.CheckOutFormBean;

import javax.validation.Valid;
import java.util.*;

@Slf4j
@Controller
public class OrderCartController {
    @Autowired
    private UserDAO userDao;
    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private OrderProductDAO orderProductDAO;


    @RequestMapping(value = "/cart/check-out/{productid}", method = RequestMethod.GET)
    public ModelAndView buyNow(@PathVariable("productid") Integer productId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("product/orderCart");

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user = userDao.findByEmail(username);

        Order order = new Order();
        OrderProduct orderDetail = new OrderProduct();

        order.setStatus("PENDING");
        order.setOrderDate(new Date());
        order.setUser(user);
        orderDAO.save(order);


        orderDetail.setOrder(order);
        orderDetail.setProduct(productDAO.findById(productId));
        orderDetail.setQuantity(1);
        orderProductDAO.save(orderDetail);

        Set<OrderProduct> orderProductList = new HashSet<>();
        orderProductList.add(orderDetail);
        order.setOrderProducts(orderProductList);
        orderDAO.save(order);


        List<Map<String, Object>> cartProducts = orderProductDAO.getCartProducts(user.getId(), "PENDING");
        response.addObject("cartProducts", cartProducts);
        System.out.println(cartProducts);
        return response;
    }

    @RequestMapping(value = "/cart/addTo-cart/{productid}", method = RequestMethod.GET)
    public ModelAndView addToCart(@PathVariable("productid") Integer productId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/product/all");

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user = userDao.findByEmail(username);

        Order order = orderDAO.findByUserAndStatus(user, "PENDING");

        if (order == null) {

            order = new Order();

            order.setStatus("PENDING");
            order.setOrderDate(new Date());
            order.setUser(user);
            order = orderDAO.save(order);
        }

        OrderProduct orderDetail = orderProductDAO.findByProduct_IdAndOrderId(productId, order.getId());

        if (orderDetail == null) {
            orderDetail = new OrderProduct();
            orderDetail.setOrder(order);
            orderDetail.setProduct(productDAO.findById(productId));
            orderDetail.setQuantity(1);
            orderDetail = orderProductDAO.save(orderDetail);
        } else {

            orderDetail.setQuantity(orderDetail.getQuantity() + 1);

        }

        Set<OrderProduct> orderProductList = new HashSet<>();
        orderProductList.add(orderDetail);
        order.setOrderProducts(orderProductList);
        orderDAO.save(order);


        List<Map<String, Object>> cartProducts = orderProductDAO.getCartProducts(order.getUser().getId(), "PENDING");
        response.addObject("cartProducts", cartProducts);
        return response;
    }

    @RequestMapping(value = "/cart/check-out/", method = RequestMethod.GET)
    public ModelAndView showCart() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("product/orderCart");

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user = userDao.findByEmail(username);


        List<Map<String, Object>> cartProducts = orderProductDAO.getCartProducts(user.getId(), "PENDING");
        response.addObject("cartProducts", cartProducts);


        return response;


    }


    /**
     * save all currnet cart in pending, change to purchase once payment info has been varied. save the purchase and order details.
     */

    @RequestMapping(value = "/cart/pay", method = RequestMethod.GET)
    public ModelAndView pay() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/thanks");


        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user = userDao.findByEmail(username);

        Order order = orderDAO.findByUserAndStatus(user, "PENDING");
        order.setStatus("PAID");
        orderDAO.save(order);
        return response;


    }

    @RequestMapping(value = "/cart/deleteItem/{id}", method = RequestMethod.GET)
    public ModelAndView productRemove(@PathVariable("id") Integer orderProductId) throws Exception {

        OrderProduct currentCart = orderProductDAO.findById(orderProductId);

        if (currentCart == null) {
            log.info("selectedCartLine is null");
            // this is an error
        } else {

            orderProductDAO.delete(currentCart);
            System.out.println(" removed from cart");
        }

        return new ModelAndView("redirect:/cart/check-out/");

    }

    @RequestMapping(value = "/cart/addPay", method = RequestMethod.POST)
    public String submitPayment(CheckOutFormBean form) throws Exception {
        log.info(form.toString());

        //get the current user and the current cart that is pending
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        User user = userDao.findByEmail(username);
        Order order = orderDAO.findByUserAndStatus(user, "PENDING");
        order.setCreditCard(form.getCreditCard());
        order.setShippingAddress(form.getShippingAddress());
        orderDAO.save(order);


        return "redirect:/cart/pay";
    }

    @RequestMapping(value = "/cart/checkout", method = RequestMethod.GET)
    public ModelAndView checkOutForm() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("product/checkOut");
        return response;

    }

}
