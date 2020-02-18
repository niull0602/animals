package com.example.animals.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_goods")
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "good_name")
    private String goodName;

    /**
     * 商品剩余量
     */
    @Column(name = "good_number")
    private Integer goodNumber;

    @Column(name = "good_price")
    private Double goodPrice;

    @Column(name = "good_img")
    private String goodImg;

    @Column(name = "good_imgs")
    private String goodImgs;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "type_id")
    private Long typeId;

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
     * @return good_name
     */
    public String getGoodName() {
        return goodName;
    }

    /**
     * @param goodName
     */
    public void setGoodName(String goodName) {
        this.goodName = goodName == null ? null : goodName.trim();
    }

    /**
     * 获取商品剩余量
     *
     * @return good_number - 商品剩余量
     */
    public Integer getGoodNumber() {
        return goodNumber;
    }

    /**
     * 设置商品剩余量
     *
     * @param goodNumber 商品剩余量
     */
    public void setGoodNumber(Integer goodNumber) {
        this.goodNumber = goodNumber;
    }

    /**
     * @return good_price
     */
    public Double getGoodPrice() {
        return goodPrice;
    }

    /**
     * @param goodPrice
     */
    public void setGoodPrice(Double goodPrice) {
        this.goodPrice = goodPrice;
    }

    /**
     * @return good_img
     */
    public String getGoodImg() {
        return goodImg;
    }

    /**
     * @param goodImg
     */
    public void setGoodImg(String goodImg) {
        this.goodImg = goodImg == null ? null : goodImg.trim();
    }

    /**
     * @return good_imgs
     */
    public String getGoodImgs() {
        return goodImgs;
    }

    /**
     * @param goodImgs
     */
    public void setGoodImgs(String goodImgs) {
        this.goodImgs = goodImgs == null ? null : goodImgs.trim();
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

    /**
     * @return type_id
     */
    public Long getTypeId() {
        return typeId;
    }

    /**
     * @param typeId
     */
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }
}