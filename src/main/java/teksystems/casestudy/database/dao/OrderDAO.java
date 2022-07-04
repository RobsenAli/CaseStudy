package teksystems.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.casestudy.database.entity.Order;
import teksystems.casestudy.database.entity.OrderProduct;
import teksystems.casestudy.database.entity.User;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderDAO extends JpaRepository<Order, Long> {

  Order findByUserAndStatus(@Param("user") User u, @Param("status") String status);


}


