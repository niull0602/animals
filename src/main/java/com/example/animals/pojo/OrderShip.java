package com.example.animals.pojo;

import lombok.Data;

import javax.persistence.*;


@Data
@Table(name = "t_order_ship")
public class OrderShip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "order_item_id")
    private Long orderItemId;

}