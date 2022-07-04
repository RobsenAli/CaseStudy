package teksystems.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.dao.OrderProductDAO;
import teksystems.casestudy.database.dao.ProductDAO;
import teksystems.casestudy.database.dao.UserDAO;
import teksystems.casestudy.database.entity.Product;

import java.util.List;

@Slf4j
@Controller
public class CartController {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private OrderProductDAO orderProductDAO;


    @RequestMapping(value = "/shop/listing", method = RequestMethod.GET)
    public ModelAndView listall() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("cart/product");

        List<Product> allproducts = productDAO.findAll();
        response.addObject("allproducts",allproducts);
        log.info("products available");

        return response;
    }

    }

