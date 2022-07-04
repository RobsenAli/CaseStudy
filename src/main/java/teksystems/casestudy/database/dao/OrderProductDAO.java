package teksystems.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.casestudy.database.entity.OrderProduct;
import teksystems.casestudy.database.entity.Product;
import teksystems.casestudy.database.entity.User;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderProductDAO extends JpaRepository<OrderProduct, Long> {

    public OrderProduct findById(@Param("id") Integer id);

    // this is not necessarily in scope for the case study
    @Query(value = " select product_id, count(*) as cnt, p.price as price,(p.price*count(*)) as total, p.name from order_products op, products p where op.product_id = p.id group by product_id",
            nativeQuery = true)
    List<Map<String, Object>> getProductNameAndOderCount();

    @Query(value = "select p.id as product_id, p.name, p.price, op.quantity,  op.id, o.id as order_id, (price * quantity) as total " +
            "from products p, order_products op, orders o " +
            "where p.id = op.product_id and o.id = op.order_id " +
            "and o.user_id = :userId and status = :status", nativeQuery = true)
    List<Map<String, Object>> getCartProducts(@Param("userId") Integer userId, @Param("status") String status);

    @Query(value = "SELECT * FROM orders WHERE user_id = :userId AND cart_status = :cartStatus", nativeQuery = true)
    public OrderProduct findByUserIdAndCartStatus(@Param("userId") Integer userId, @Param("cartStatus") String cartStatus);

   OrderProduct findByProduct_IdAndOrderId(@Param("productId") Integer productid, @Param("orderId") Integer orderid);






// in your JSP you can do a for each
// for each orderProduct var=op
// ${op.cnt}   ${op.product_id} ${op.name}
// end for each

    public OrderProduct findByProduct(@Param("product") Product product);

}