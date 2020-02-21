package com.example.animals.response;

import com.example.animals.pojo.Goods;
import lombok.Data;
import lombok.ToString;

/**
 * Created by lemon on 2020-02-20 22:04.
 */
@Data
@ToString
public class OrderItemResponse {
    private Long id;

    private Goods good;

    private Integer itemNum;

    private Double subprice;

}
