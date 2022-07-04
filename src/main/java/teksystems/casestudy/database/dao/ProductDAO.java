package teksystems.casestudy.database.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.casestudy.database.entity.Product;
import teksystems.casestudy.database.entity.User;

import java.util.List;


@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {
    Product findById(@Param("id") Integer id);

    List<Product> findByName(@Param("name") String productName);

    List<Product> findByNameIgnoreCaseContaining(@Param("name") String name);




}
