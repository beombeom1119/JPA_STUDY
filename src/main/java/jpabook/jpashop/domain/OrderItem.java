package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class OrderItem {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name ="ORDER_ID")
    private Long orderId;

    @Column(name ="ITEM_ID")
    private Long itemId;

    private int orderPrice;

    private int count;

}
