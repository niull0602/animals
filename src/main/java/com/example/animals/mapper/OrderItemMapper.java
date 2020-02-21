package com.example.animals.mapper;

import com.example.animals.pojo.OrderItem;
import com.example.animals.response.OrderItemResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderItemMapper extends CommonMapper<OrderItem> {
    public List<OrderItemResponse> selectOrderItemByOrderId(@Param(value="id")Long id);
}