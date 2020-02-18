package com.example.animals.pojo;

import javax.persistence.*;

@Table(name = "t_order_ship")
public class OrderShip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "order_item_id")
    private Long orderItemId;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return order_id
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @return order_item_id
     */
    public Long getOrderItemId() {
        return orderItemId;
    }

    /**
     * @param orderItemId
     */
    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }
}