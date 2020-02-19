package com.example.animals.request;

import com.example.animals.bo.GoodsImgBo;
import lombok.Data;

import java.util.List;

/**
 * Created by lemon on 2020-02-19 0:31.
 */
@Data
public class AddGoodRequest {
    private String goodName;

    /**
     * 商品剩余量
     */
    private Integer goodNumber;

    private Double goodPrice;
    /**
     * 商品大图
     */
    private String goodImg;


    /**
     * 商品详情多图
     */
    private List<String> goodsImgBoList;
    /**
     * 商品的种类
     */
    private Long typeId;
}
