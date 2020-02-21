package com.example.animals.response;

import lombok.Data;


/**
 * Created by lemon on 2020-02-20 15:59.
 */
@Data
public class ShopCarResponse {
    private Long id;

    private Long goodId;

    private Double goodPrice;

    private String goodImg;

    private Integer buyNum;
}
