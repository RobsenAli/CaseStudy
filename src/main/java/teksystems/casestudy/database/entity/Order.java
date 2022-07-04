package teksystems.casestudy.database.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@ToString
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "order_date")
    Date orderDate;
    @Column(name = "credit_card")
    String creditCard;
    @Column(name = "status")
    String status;
    @Column(name = "shipping_address")
    String shippingAddress;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<OrderProduct> orderProducts;

}
