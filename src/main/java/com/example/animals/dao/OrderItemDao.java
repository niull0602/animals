package com.example.animals.dao;

import com.example.animals.mapper.OrderItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by lemon on 2020-02-18 22:11.
 */
@Repository
public class OrderItemDao {
    @Autowired
    private OrderItemMapper orderItemMapper;


}
