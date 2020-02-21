package com.example.animals.dao;

import com.example.animals.mapper.OrderShipMapper;
import com.example.animals.pojo.OrderShip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lemon on 2020-02-18 22:10.
 */
@Repository
public class OrderShipDao {
    @Autowired
    private OrderShipMapper orderShipMapper;

    public Integer insert(List<OrderShip> orderShipList) {
        return orderShipMapper.insertList(orderShipList);
    }

    public Integer deleteOrderShipAndOrderItem(Long id) {
        return orderShipMapper.deleteOrderShipAndOrderItem(id);
    }
}
