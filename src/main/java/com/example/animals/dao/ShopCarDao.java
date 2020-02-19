package com.example.animals.dao;

import com.example.animals.mapper.ShopCarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by lemon on 2020-02-18 22:13.
 */
@Repository
public class ShopCarDao {
    @Autowired
    private ShopCarMapper shopCarMapper;


}
