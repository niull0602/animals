package com.example.animals.service;

import com.example.animals.request.AddOrderRequest;
import com.example.animals.request.UpdateOrderRequest;
import com.example.animals.response.OrdersResponseList;

/**
 * Created by lemon on 2020-02-20 19:41.
 */
public interface OrderService {
    Integer addOrder(AddOrderRequest orderRequest);

    Integer updateOrderById(UpdateOrderRequest request);

    OrdersResponseList getOrdersByUserId(Long userId, Integer pageNumber, Integer pageSize);

    Integer deleteOrderById(Long id);

    OrdersResponseList getAllOrders(Integer pageNumber, Integer pageSize);

}
