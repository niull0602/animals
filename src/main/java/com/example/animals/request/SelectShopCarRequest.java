package com.example.animals.request;

import lombok.Data;

/**
 * Created by lemon on 2020-02-20 19:17.
 */
@Data
public class SelectShopCarRequest {
    private Long userId;
    // 登录成功后的token
    private String token;

    private Integer pageNumber;

    private Integer pageSize;
}
