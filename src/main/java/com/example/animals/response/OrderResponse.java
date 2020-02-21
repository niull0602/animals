package com.example.animals.response;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by lemon on 2020-02-20 21:32.
 */
@Data
public class OrderResponse {
    private Long id;

    private String orderCode;

    private Double totalPrice;

    private Integer status;

    private Date createTime;

    private List<OrderItemResponse> itemList;
}
