package com.example.animals.dao;

import com.example.animals.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by lemon on 2020-02-18 22:08.
 */
@Repository
public class OrdersDao {
    @Autowired
    private OrdersMapper ordersMapper;


}
