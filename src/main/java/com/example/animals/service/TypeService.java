package com.example.animals.service;

import com.example.animals.request.AddTypeRequest;
import com.example.animals.response.AnimalsTypeResponse;
import com.example.animals.response.GoodTypeResponse;
import com.example.animals.response.TypeResponse;

import java.util.List;

/**
 * Created by lemon on 2020-02-19 11:49.
 */
public interface TypeService {
    AnimalsTypeResponse getAnimalsType();

    GoodTypeResponse getGoodsType(Long typeId);

    Integer add(AddTypeRequest request);

    Integer deleteTpyeById(Long id);

    List<TypeResponse> getAllType();
}
