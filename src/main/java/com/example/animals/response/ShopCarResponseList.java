package com.example.animals.response;

import lombok.Data;

import java.util.List;

/**
 * Created by lemon on 2020-02-20 16:08.
 */
@Data
public class ShopCarResponseList {
    private List<ShopCarResponse> list;
    private Long total;
}
