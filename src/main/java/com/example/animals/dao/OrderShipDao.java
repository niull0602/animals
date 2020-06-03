package com.example.animals.dao;

import com.example.animals.mapper.OrderShipMapper;
import com.example.animals.pojo.OrderItem;
import com.example.animals.pojo.OrderShip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by lemon on 2020-02-18 22:10.
 */
@Repository
public class OrderShipDao {
    @Autowired
    private OrderShipMapper orderShipMapper;

    public Integer insert(OrderShip orderShipList) {
        return orderShipMapper.insert(orderShipList);
    }

    public Integer deleteOrderShipAndOrderItem(Long id) {
        return orderShipMapper.deleteOrderShipAndOrderItem(id);
    }

    public OrderShip selectOrderItemByOrderId(Long id) {
        Example example = new Example(OrderShip.class);
        example.createCriteria()
                .andEqualTo("orderId",id);
        return orderShipMapper.selectByExample(example).get(0);
    }
}
