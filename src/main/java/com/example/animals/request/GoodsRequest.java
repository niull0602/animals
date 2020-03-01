package com.example.animals.request;


import com.example.animals.bo.ImgBo;
import lombok.Data;


import java.util.List;

/**
 * Created by lemon on 2020-02-18 23:55.
 */
@Data
public class GoodsRequest {
    private Long id;

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
    private List<ImgBo> goodsImgBoList;
    /**
     * 书的种类
     */
    private Long typeId;
}
