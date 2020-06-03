package com.example.animals.mapper;

import com.example.animals.pojo.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderItemMapper extends CommonMapper<OrderItem> {
}