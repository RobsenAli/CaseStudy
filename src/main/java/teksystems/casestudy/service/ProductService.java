package teksystems.casestudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import teksystems.casestudy.database.dao.ProductDAO;

public class ProductService {
        @Autowired
        ProductDAO productDAO;

}
