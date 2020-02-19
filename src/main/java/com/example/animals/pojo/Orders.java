package com.example.animals.pojo;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import javax.persistence.*;
@Entity
@Table(name = "t_orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    /**
     * 订单编号
     */
    @Column(name = "order_code",columnDefinition = "varchar(255) comment '订单编号'")
    private String orderCode;

    /**
     * 总价格
     */
    @Column(name = "total_price",columnDefinition = "double comment '总价格'")
    private Double totalPrice;

    /**
     * 订单状------0:未付款 1:已付款未发货  2:已发货  3:确认收货
     */
    @Column(columnDefinition = "int comment '订单状态---0:未付款 1:已付款未发货  2:已发货  3:确认收货 '")
    private Integer status;
    @CreationTimestamp
    @Column(name = "create_time")
    private Date createTime;
    @UpdateTimestamp
    @Column(name = "update_time")
    private Date updateTime;

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
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取订单编号
     *
     * @return order_code - 订单编号
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * 设置订单编号
     *
     * @param orderCode 订单编号
     */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    /**
     * 获取总价格
     *
     * @return total_price - 总价格
     */
    public Double getTotalPrice() {
        return totalPrice;
    }

    /**
     * 设置总价格
     *
     * @param totalPrice 总价格
     */
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 获取订单状------0:未付款 1:已付款未发货  2:已发货  3:已收货
     *
     * @return status - 订单状------0:未付款 1:已付款未发货  2:已发货  3:已收货
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置订单状------0:未付款 1:已付款未发货  2:已发货  3:已收货
     *
     * @param status 订单状------0:未付款 1:已付款未发货  2:已发货  3:已收货
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}