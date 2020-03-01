package com.example.animals.response;

import lombok.Data;

import java.util.List;

/**
 * Created by lemon on 2020-02-20 21:33.
 */
@Data
public class OrdersResponseList {
    private List<OrderResponse> list;
    private Long total;
}
