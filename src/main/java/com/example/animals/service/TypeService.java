package com.example.animals.service;

import com.example.animals.response.AnimalsTypeResponse;
import com.example.animals.response.GoodTypeResponse;

/**
 * Created by lemon on 2020-02-19 11:49.
 */
public interface TypeService {
    AnimalsTypeResponse getAnimalsType();

    GoodTypeResponse getGoodsType(Long typeId);
}
