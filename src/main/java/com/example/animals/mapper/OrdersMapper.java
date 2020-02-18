package com.example.animals.mapper;

import com.example.animals.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdersMapper extends CommonMapper<Orders> {
}