package com.example.animals.pojo;

import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "t_shop_car")
@ToString
@Entity
public class ShopCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "good_id")
    private Long goodId;

    /**
     * 购买数
     */
    @Column(name = "buy_num",columnDefinition = "int comment '购买数'")
    private Integer buyNum;

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
     * 获取购买数
     *
     * @return buy_num - 购买数
     */
    public Integer getBuyNum() {
        return buyNum;
    }

    /**
     * 设置购买数
     *
     * @param buyNum 购买数
     */
    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }
}