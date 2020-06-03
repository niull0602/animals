package com.example.animals.controller;


import com.example.animals.common.SzpJsonResult;
import com.example.animals.request.AddOrderRequest;
import com.example.animals.request.UpdateOrderRequest;
import com.example.animals.response.OrdersResponseList;
import com.example.animals.service.OrderService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by lemon on 2020-02-20 19:41.
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @ApiOperation("添加订单")
    @PostMapping("post/order")
    public SzpJsonResult<Integer> postOrder(@RequestBody @ApiParam(name="传入对象",value="传入json格式",required=true) AddOrderRequest orderRequest){
        return SzpJsonResult.ok(orderService.addOrder(orderRequest));
    }

    @PutMapping(value = "update/order/id")
    public SzpJsonResult<Integer> updateOrderById(@RequestBody UpdateOrderRequest request){
        return SzpJsonResult.ok(orderService.updateOrderById(request));
    }
    @ApiOperation("用户查看所有订单")
    @GetMapping(value = "get/orders/{userId}")
    public SzpJsonResult<OrdersResponseList> getOrdersByUserId(@PathVariable(value = "userId") @ApiParam(name ="userId",value = "用户id") Long userId,
                                                               @RequestParam(value = "page",defaultValue = "1")  Integer pageNumber,
                                                               @RequestParam(value = "size",defaultValue = "10")Integer pageSize){
        return SzpJsonResult.ok(orderService.getOrdersByUserId(userId,pageNumber, pageSize));
    }
    @ApiOperation("查看所有订单")
    @GetMapping(value = "get/all/orders")
    public SzpJsonResult<OrdersResponseList> getAllOrders(@RequestParam(value = "page",defaultValue = "1") Integer pageNumber,
                                                          @RequestParam(value = "size",defaultValue = "10")Integer pageSize){
        return SzpJsonResult.ok(orderService.getAllOrders(pageNumber, pageSize));
    }

    @ApiOperation("根据订单状态查询所有订单")
    @GetMapping(value = "get/orders/status")
    public SzpJsonResult<OrdersResponseList> getOrdersByStatus(@RequestParam(value = "status")  @ApiParam(value = "订单状态")Integer status,
                                                               @RequestParam(value = "page",defaultValue = "1") Integer pageNumber,
                                                                @RequestParam(value = "size",defaultValue = "10")Integer pageSize){
        return SzpJsonResult.ok(orderService.getOrdersByStatus(status,pageNumber, pageSize));
    }

    @ApiOperation("用户根据订单状态查询所有订单")
    @GetMapping(value = "get/orders/status/userId")
    public SzpJsonResult<OrdersResponseList> getOrdersByStatusAndUserId(@RequestParam(value = "userId") @ApiParam(name ="userId",value = "用户id")Long userId,
                                                                        @RequestParam(value = "status")  @ApiParam(value = "订单状态")Integer status,
                                                                        @RequestParam(value = "page",defaultValue = "1") Integer pageNumber,
                                                                        @RequestParam(value = "size",defaultValue = "10")Integer pageSize){
        return SzpJsonResult.ok(orderService.getOrdersByStatusAndUserId(userId,status,pageNumber, pageSize));
    }

    @DeleteMapping(value = "delete/order/{id}")
    public SzpJsonResult<Integer> deleteOrderById(@PathVariable(value = "id")Long id){
        return SzpJsonResult.ok(orderService.deleteOrderById(id));
    }


}
