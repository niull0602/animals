package com.example.animals.mapper;

import com.example.animals.pojo.OrderShip;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderShipMapper extends CommonMapper<OrderShip> {
    Integer deleteOrderShipAndOrderItem(@Param(value="id") Long id);
}