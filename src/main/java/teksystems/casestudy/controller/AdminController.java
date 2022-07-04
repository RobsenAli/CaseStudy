package teksystems.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.dao.ProductDAO;
import teksystems.casestudy.database.entity.Product;
import teksystems.casestudy.formbean.ProductFormBean;

import javax.validation.Valid;

@Slf4j
@Controller
public class AdminController {


    @Autowired
    private ProductDAO productDao;

//    @PreAuthorize("hasAuthority('Admin')")
    @RequestMapping(value = "/home/classes", method = RequestMethod.GET)
    public ModelAndView showform() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("cart/addProduct");

        ProductFormBean form = new ProductFormBean();
        response.addObject("form", form);
        log.info("purchase");

        return response;
    }

    @PreAuthorize("hasAuthority('Admin')")
    @RequestMapping(value = "/cart/addProduct", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView addProduct(@Valid ProductFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();
        log.info("Purchase submit");
        log.info(form.toString());

        if (bindingResult.hasErrors()) {

            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug(((FieldError) error).getField() + " " + error.getDefaultMessage());
            }
            response.addObject("form", form);
            response.addObject("bindingResult", bindingResult);
            response.setViewName("home/classes");
            return response;
        }


        Product product = new Product();
        if (product != null) {
            product = productDao.findById(form.getProductId());
        }

        if (product == null) {
            product = new Product();
        }

        product.setDescription(form.getDescription());
        product.setName(form.getProductName());
        product.setPrice(form.getPrice().intValue());
        product.setImgUrl(form.getImageUrl());

        productDao.save(product);


        response.setViewName("redirect:/shop/listing");

        return response;


    }
}