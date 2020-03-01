package com.example.animals.request;

import lombok.Data;

import java.util.Date;

/**
 * Created by lemon on 2020-02-20 20:49.
 */
@Data
public class UpdateOrderRequest {
    private Long id;

    private Long userId;

    private String orderCode;

    private Double totalPrice;

    private Integer status;

    private String token;
}
