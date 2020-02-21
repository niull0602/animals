package com.example.animals.request;

import lombok.Data;
import lombok.ToString;

/**
 * Created by lemon on 2020-02-20 13:25.
 */
@Data
@ToString
public class AddShopCarRequest {
    private Long userId;

    private Long goodId;

    private Integer buyNum;

    private String token;
}
