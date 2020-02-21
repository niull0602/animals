package com.example.animals.request;

import lombok.Data;

import java.util.List;

/**
 * Created by lemon on 2020-02-20 19:52.
 */
@Data
public class AddOrderRequest {
    private Long userId;

    private String token;

    private Double totalPrice;

    private Integer status;

    private List<AddOrderItemRequest> itemRequestList;
}
