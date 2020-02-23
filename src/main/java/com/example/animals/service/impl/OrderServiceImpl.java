package com.example.animals.service.impl;

import com.example.animals.dao.OrderItemDao;
import com.example.animals.dao.OrderShipDao;
import com.example.animals.dao.OrdersDao;
import com.example.animals.dao.ShopCarDao;
import com.example.animals.pojo.OrderItem;
import com.example.animals.pojo.OrderShip;
import com.example.animals.pojo.Orders;
import com.example.animals.request.AddOrderItemRequest;
import com.example.animals.request.AddOrderRequest;
import com.example.animals.request.UpdateOrderRequest;
import com.example.animals.response.OrderItemResponse;
import com.example.animals.response.OrderResponse;
import com.example.animals.response.OrdersResponseList;
import com.example.animals.service.OrderService;
import com.example.animals.service.UserService;
import com.example.animals.utils.JwtUtil;
import com.example.animals.utils.OrderCodeUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lemon on 2020-02-20 19:42.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private OrderShipDao orderShipDao;
    @Autowired
    private OrderItemDao orderItemDao;
    @Autowired
    private ShopCarDao shopCarDao;
    @Autowired
    private UserService userService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer addOrder(AddOrderRequest orderRequest) {
        String token = orderRequest.getToken();
        Long userId = userService.getUserId(token);
        if (userId==null){
            return 0;
        }
        List<AddOrderItemRequest> itemRequestList = orderRequest.getItemRequestList();
        List<OrderItem> orderItemList = new ArrayList<>();
        Integer res=0;
        List<Long> shopCarIds = new ArrayList<>();
        for (AddOrderItemRequest request : itemRequestList){
            OrderItem orderItem = new OrderItem();
            BeanUtils.copyProperties(request,orderItem);
            orderItemList.add(orderItem);
            shopCarIds.add(request.getShopCarId());
        }
        res = shopCarDao.deleteShopCarByIds(shopCarIds);
        res = orderItemDao.insertList(orderItemList);
        Orders orders = new Orders();
        BeanUtils.copyProperties(orderRequest,orders);
        orders.setCreateTime(new Date());
        orders.setUpdateTime(new Date());
        orders.setOrderCode(OrderCodeUtil.getOrderNo());
        res = ordersDao.insert(orders);
        List<OrderShip> orderShipList = new ArrayList<>();
        for (OrderItem orderItem : orderItemList){
            OrderShip orderShip = new OrderShip();
            orderShip.setOrderId(orders.getId());
            orderShip.setOrderItemId(orderItem.getId());
            orderShipList.add(orderShip);
        }
        res = orderShipDao.insert(orderShipList);
        return res;
    }

    @Override
    public Integer updateOrderById(UpdateOrderRequest request) {
        String token = request.getToken();
        if (userService.getUserId(token) == null) {
            return 0;
        }
        Orders orders = new Orders();
        BeanUtils.copyProperties(request,orders);
        return ordersDao.update(orders);
    }

    @Override
    public OrdersResponseList getOrdersByUserId(Long userId, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        OrdersResponseList ordersResponseList = new OrdersResponseList();
        List<Orders> ordersDaoList =  ordersDao.getOrdersByUserId(userId);
        PageInfo<Orders> pageInfo = new PageInfo<>(ordersDaoList);
        //返回的数据集合
        List<OrderResponse> orderResponseList = new ArrayList<>();
        List<Orders> ordersList = pageInfo.getList();
        for (Orders order:ordersList){
            OrderResponse orderResponse = new OrderResponse();
            List<OrderItemResponse> orderItemResponseTemp = orderItemDao.selectOrderItemByOrderId(order.getId());
            BeanUtils.copyProperties(order,orderResponse);
            orderResponse.setItemList(orderItemResponseTemp);
            orderResponseList.add(orderResponse);
        }
        ordersResponseList.setList(orderResponseList);
        ordersResponseList.setTotal(pageInfo.getTotal());
        return ordersResponseList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteOrderById(Long id) {
        return orderShipDao.deleteOrderShipAndOrderItem(id);
    }

    @Override
    public OrdersResponseList getAllOrders(Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        OrdersResponseList ordersResponseList = new OrdersResponseList();
        List<Orders> ordersDaoList =  ordersDao.getAllOrders();
        PageInfo<Orders> pageInfo = new PageInfo<>(ordersDaoList);
        //返回的数据集合
        List<OrderResponse> orderResponseList = new ArrayList<>();
        List<Orders> ordersList = pageInfo.getList();
        for (Orders order:ordersList){
            OrderResponse orderResponse = new OrderResponse();
            List<OrderItemResponse> orderItemResponseTemp = orderItemDao.selectOrderItemByOrderId(order.getId());
            BeanUtils.copyProperties(order,orderResponse);
            orderResponse.setItemList(orderItemResponseTemp);
            orderResponseList.add(orderResponse);
        }
        ordersResponseList.setList(orderResponseList);
        ordersResponseList.setTotal(pageInfo.getTotal());
        return ordersResponseList;
    }
}
