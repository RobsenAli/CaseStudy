package teksystems.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import teksystems.casestudy.database.dao.ProductDAO;
import teksystems.casestudy.database.entity.Product;
import teksystems.casestudy.formbean.ProductFormBean;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class ProductController {

    @Autowired
    private ProductDAO productDao;


    @RequestMapping(value = "add/product", method = RequestMethod.GET)
    public ModelAndView createProduct() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("product/addProduct");
        ProductFormBean form = new ProductFormBean();
        response.addObject("form", form);
        return response;
    }


    @RequestMapping(value = "/product/productSubmit", method = RequestMethod.GET)
    public ModelAndView addSubmit(@Valid ProductFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();
        log.info(form.toString());

        if (bindingResult.hasErrors()) {

            for (ObjectError error : bindingResult.getAllErrors()) {
                log.info(((FieldError) error).getField() + " " + error.getDefaultMessage());
            }
            response.addObject("form", form);
            response.addObject("bindingResult", bindingResult);
            response.setViewName("product/addProduct");

            return response;
        }
        Product product = productDao.findById(form.getProductId());

        if (product == null) {
            product = new Product();
        }
        product.setId(form.getProductId());
        product.setPrice(form.getPrice());
        product.setImgUrl(form.getImageUrl());
        product.setName(form.getProductName());
        product.setCategory(form.getCategory());
        product.setDescription(form.getDescription());

        productDao.save(product);

        log.info(form.toString());

        response.setViewName("redirect:/user/productAdded");
        return new ModelAndView("redirect:/user/productAdded");

//        return response;
    }

    //@RequestMapping(value = "/user/edit/{userId}", method = RequestMethod.GET)
    @GetMapping("/product/edit/{productId}")
    //public ModelAndView editUser(@RequestParam("userId") Integer userId) throws Exception {
    public ModelAndView editProduct(@PathVariable("productId") Integer productId) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("product/addProduct");

        Product product = productDao.findById(productId);

        ProductFormBean form = new ProductFormBean();

        product.setId(form.getProductId());
        product.setPrice(form.getPrice());
        product.setImgUrl(form.getImageUrl());
        product.setName(form.getProductName());
        product.setCategory(form.getCategory());
        product.setDescription(form.getDescription());

        response.addObject("form", form);
        return response;

    }

    @RequestMapping(value = "/product/search", method = RequestMethod.GET)
    public ModelAndView searchProduct(@RequestParam(value = "productName", required = false) String productName) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("product/searchProduct");

        List<Product> products = new ArrayList<>();

        // again very basic example of error checking
        if (!StringUtils.isEmpty(productName)) {
            products = productDao.findByName(productName);
        }
        response.addObject("productsModelKey", products);
        response.addObject("productName", productName);
        return response;
    }
    @RequestMapping(value = "/product/shop", method = RequestMethod.GET)
    public ModelAndView shop() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("product/productList");

        List<Product> products = productDao.findAll();



//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();
//        User user = userDao.findByEmail(username);

        response.addObject("products", products);
        return response;

    }
    @RequestMapping(value = "/product/added", method = RequestMethod.GET)
    public ModelAndView addedProduct() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/productAdded");
        return response;
    }
    @RequestMapping(value = "/product/all", method = RequestMethod.GET)
    public ModelAndView product() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("product/product");

        List<Product> allProducts = productDao.findAll();

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();
//        User user = userDao.findByEmail(username);

        response.addObject("allProducts", allProducts);
        return response;
    }

}