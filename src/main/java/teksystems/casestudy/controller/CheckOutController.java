package teksystems.casestudy.controller;//package teksystems.casestudy.controller;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//import teksystems.casestudy.database.dao.OrderDAO;
//import teksystems.casestudy.database.dao.OrderProductDAO;
//import teksystems.casestudy.database.dao.ProductDAO;
//import teksystems.casestudy.database.dao.UserDAO;
//import teksystems.casestudy.database.entity.User;
//
//@Slf4j
//@Controller
//public class CheckOutController {
//    @Autowired
//    private UserDAO userDao;
//    @Autowired
//    private ProductDAO productDAO;
//    @Autowired
//    private OrderDAO orderDAO;
//    @Autowired
//    private OrderProductDAO orderProductDAO;
//
//    @RequestMapping(value = "/cart/check-out/{productid}", method = RequestMethod.GET)
//    public ModelAndView addToCart(@PathVariable("productid") Integer productId) throws Exception {
//        ModelAndView response = new ModelAndView();
//        response.setViewName("product/checkOut");
//
//
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        String username;
//        if (principal instanceof UserDetails) {
//            username = ((UserDetails) principal).getUsername();
//        } else {
//            username = principal.toString();
//        }
//        User user = userDao.findByEmail(username);
//
//
//        return response;
//    }
//}
