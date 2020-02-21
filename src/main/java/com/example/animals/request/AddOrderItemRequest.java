package com.example.animals.request;

import lombok.Data;

/**
 * Created by lemon on 2020-02-20 19:56.
 */
@Data
public class AddOrderItemRequest {
    private Long shopCarId;

    private Long goodId;

    private Integer itemNum;

    private Double subprice;
}
