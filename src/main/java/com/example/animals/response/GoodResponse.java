package com.example.animals.response;

import com.example.animals.bo.GoodsImgBo;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

/**
 * Created by lemon on 2020-02-19 14:35.
 */
@Data
public class GoodResponse {
    private Long id;

    private String goodName;
    /**
     * 商品剩余量
     */
    private Integer goodNumber;

    private Double goodPrice;

    private String goodImg;

    private List<GoodsImgBo> goodsImgBoList;
}
