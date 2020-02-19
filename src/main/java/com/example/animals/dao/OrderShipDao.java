package com.example.animals.dao;

import com.example.animals.mapper.OrderShipMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by lemon on 2020-02-18 22:10.
 */
@Repository
public class OrderShipDao {
    @Autowired
    private OrderShipMapper orderShipMapper;


}
