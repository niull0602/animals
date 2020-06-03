package com.example.animals.dao;

import com.example.animals.mapper.OrderItemMapper;
import com.example.animals.pojo.OrderItem;
import com.example.animals.response.OrderItemResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lemon on 2020-02-18 22:11.
 */
@Repository
public class OrderItemDao {
    @Autowired
    private OrderItemMapper orderItemMapper;

    public Integer insertList(List<OrderItem> orderItemList) {
        return orderItemMapper.insertList(orderItemList);
    }


    public OrderItem selectOrderItemById(Long orderItemId) {
        return orderItemMapper.selectByPrimaryKey(orderItemId);
    }
}
