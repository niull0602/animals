package com.example.animals.response;

import com.example.animals.pojo.Goods;
import com.example.animals.pojo.User;
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

    private String createTime;

    private Long goodId;

    private Goods good;

    private Integer itemNum;

    private User user;
}
