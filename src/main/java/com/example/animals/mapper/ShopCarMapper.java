package com.example.animals.mapper;

import com.example.animals.pojo.ShopCar;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopCarMapper extends CommonMapper<ShopCar> {
    public Integer updateShopCarByList(List<ShopCar> list);
}