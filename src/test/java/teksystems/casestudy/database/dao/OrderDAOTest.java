package teksystems.casestudy.database.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import teksystems.casestudy.database.entity.Order;
import teksystems.casestudy.database.entity.User;

import java.util.Date;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@Slf4j
@ActiveProfiles({"test", "default"})
class OrderDAOTest {


    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private OrderProductDAO orderProductDAO;

    @Autowired
    private UserDAO userDAO;



    @Test
    void findUserAndStatus() {


        // dummy user
        User user = new User();
        user.setId(1);
        user.setFirstName("obsa");
        user.setLastName("ali");
        user.setEmail("obsa@me.com");
        user.setPassword("123");
        user.setCreateDate(new Date());

        userDAO.save(user);


        //dummy order data
        Order order = new Order();
        order.setId(1);
        order.setUser(user);
        order.setOrderDate(new Date());
        order.setShippingAddress("1234 th ave");
        order.setStatus("pending");
        order.setCreditCard("122334344243");
        order.setOrderProducts(new HashSet<>());

        orderDAO.save(order);

        // testing if the data passed is the same as the one from dao
        //getting the id from order and then getting an id from that result
        Assertions.assertEquals(orderDAO.findByUserAndStatus(user, order.getStatus()).getId(), order.getId());

    }


}