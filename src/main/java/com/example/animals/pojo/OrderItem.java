package com.example.animals.pojo;

import javax.persistence.*;

@Table(name = "t_order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "good_id")
    private Long goodId;

    /**
     * 购买数量
     */
    @Column(name = "item_num")
    private Integer itemNum;

    /**
     * 小计
     */
    private Double subprice;

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
     * @return good_id
     */
    public Long getGoodId() {
        return goodId;
    }

    /**
     * @param goodId
     */
    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    /**
     * 获取购买数量
     *
     * @return item_num - 购买数量
     */
    public Integer getItemNum() {
        return itemNum;
    }

    /**
     * 设置购买数量
     *
     * @param itemNum 购买数量
     */
    public void setItemNum(Integer itemNum) {
        this.itemNum = itemNum;
    }

    /**
     * 获取小计
     *
     * @return subprice - 小计
     */
    public Double getSubprice() {
        return subprice;
    }

    /**
     * 设置小计
     *
     * @param subprice 小计
     */
    public void setSubprice(Double subprice) {
        this.subprice = subprice;
    }
}