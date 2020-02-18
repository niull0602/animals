package com.example.animals.mapper;

import com.example.animals.pojo.OrderItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderItemMapper extends CommonMapper<OrderItem> {
}