package com.example.animals.service;

import com.example.animals.request.AddShopCarRequest;
import com.example.animals.request.SelectShopCarRequest;
import com.example.animals.request.ShopCarRequest;
import com.example.animals.request.UpdateShopCarRequest;
import com.example.animals.response.ShopCarResponseList;

import java.util.List;

/**
 * Created by lemon on 2020-02-19 16:39.
 */
public interface ShopCarService {
    Integer addShopCar(AddShopCarRequest shopCarRequest);

    Integer deleteShopCarById(Long id);

    Integer deleteShopCarByIds(List<Long> ids);

    Integer updateShopCar(UpdateShopCarRequest shopCarRequest);

    ShopCarResponseList selectShopCarByUserId(SelectShopCarRequest shopCarRequest);
}
