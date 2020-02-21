package com.example.animals.dao;

import com.example.animals.mapper.ShopCarMapper;
import com.example.animals.pojo.ShopCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by lemon on 2020-02-18 22:13.
 */
@Repository
public class ShopCarDao {
    @Autowired
    private ShopCarMapper shopCarMapper;

    public Integer insert(ShopCar shopCar) {
        return shopCarMapper.insert(shopCar);
    }

    public Integer updateByList(List<ShopCar> list) {
        return shopCarMapper.updateShopCarByList(list);
    }

    public Integer deleteShopCarById(Long id) {
        return shopCarMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteShopCarByIds(List<Long> ids) {
        Example example = new Example(ShopCar.class);
        example.createCriteria()
                .andIn("id",ids);
        return shopCarMapper.deleteByExample(example);
    }

    public List<ShopCar> selectShopCarByUserId(Long userId) {
        Example example = new Example(ShopCar.class);
        example.createCriteria()
                .andEqualTo("userId",userId);
        return shopCarMapper.selectByExample(example);
    }
}
