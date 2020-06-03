package com.example.animals.dao;

import com.example.animals.mapper.OrdersMapper;
import com.example.animals.pojo.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by lemon on 2020-02-18 22:08.
 */
@Repository
public class OrdersDao {
    @Autowired
    private OrdersMapper ordersMapper;

    public Integer insert(Orders orders) {
        return ordersMapper.insert(orders);
    }

    public Integer update(Orders orders) {
        return ordersMapper.updateByPrimaryKeySelective(orders);
    }

    public List<Orders> getOrdersByUserId(Long userId) {
        Example example = new Example(Orders.class);
        example.createCriteria()
                .andEqualTo("userId",userId);
        return ordersMapper.selectByExample(example);
    }

    public Integer deleteOrderById(Long id) {
        return ordersMapper.deleteByPrimaryKey(id);
    }

    public List<Orders> getAllOrders() {
        return ordersMapper.selectAll();
    }

    public List<Orders> getOrdersByStatus(Integer status) {
        Example example = new Example(Orders.class);
        example.createCriteria()
                .andEqualTo("status",status);
        return ordersMapper.selectByExample(example);
    }

    public List<Orders> getOrdersByStatusAndUserId(Long userId, Integer status) {
        Condition condition = new Condition(Orders.class);
        condition.createCriteria()
                .andEqualTo("userId",userId)
                .andEqualTo("status",status);
        condition.setOrderByClause("create_time desc");
        return ordersMapper.selectByExample(condition);
    }
}
