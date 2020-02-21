package com.example.animals.controller;


import com.example.animals.common.SzpJsonResult;
import com.example.animals.request.AddOrderRequest;
import com.example.animals.request.UpdateOrderRequest;
import com.example.animals.response.OrdersResponseList;
import com.example.animals.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lemon on 2020-02-20 19:41.
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("add/order")
    public SzpJsonResult<Integer> addOrder(@RequestBody AddOrderRequest orderRequest){
        return SzpJsonResult.ok(orderService.addOrder(orderRequest));
    }

    @PutMapping(value = "update/order/id")
    public SzpJsonResult<Integer> updateOrderById(@RequestBody UpdateOrderRequest request){
        return SzpJsonResult.ok(orderService.updateOrderById(request));
    }

    @GetMapping(value = "get/orders/{userId}")
    public SzpJsonResult<OrdersResponseList> getOrdersByUserId(@PathVariable(value = "userId")Long userId,
                                                               @RequestParam(value = "page",defaultValue = "1") Integer pageNumber,
                                                               @RequestParam(value = "size",defaultValue = "10")Integer pageSize){
        return SzpJsonResult.ok(orderService.getOrdersByUserId(userId,pageNumber, pageSize));
    }

    @GetMapping(value = "get/all/orders")
    public SzpJsonResult<OrdersResponseList> getAllOrders(@RequestParam(value = "page",defaultValue = "1") Integer pageNumber,
                                                          @RequestParam(value = "size",defaultValue = "10")Integer pageSize){
        return SzpJsonResult.ok(orderService.getAllOrders(pageNumber, pageSize));
    }

    @DeleteMapping(value = "delete/order/{id}")
    public SzpJsonResult<Integer> deleteOrderById(@PathVariable(value = "id")Long id){
        return SzpJsonResult.ok(orderService.deleteOrderById(id));
    }


}
