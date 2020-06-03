package com.example.animals.service.impl;

import com.example.animals.dao.*;
import com.example.animals.pojo.Goods;
import com.example.animals.pojo.OrderItem;
import com.example.animals.pojo.OrderShip;
import com.example.animals.pojo.Orders;
import com.example.animals.request.AddOrderRequest;
import com.example.animals.request.UpdateOrderRequest;
import com.example.animals.response.OrderResponse;
import com.example.animals.response.OrdersResponseList;
import com.example.animals.service.OrderService;
import com.example.animals.service.UserService;
import com.example.animals.utils.DateTimeUtil;
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
    private UserService userService;
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private UserDao userDao;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer addOrder(AddOrderRequest orderRequest) {
        List<OrderItem> orderItemList = new ArrayList<>();
        Goods goods = goodsDao.findGoodsById(orderRequest.getGoodId());
        goods.setGoodNumber(goods.getGoodNumber() - orderRequest.getItemNum());
        goodsDao.updateGoods(goods);
        OrderItem orderItem = new OrderItem();
        BeanUtils.copyProperties(orderRequest, orderItem);
        orderItemList.add(orderItem);
        orderItemDao.insertList(orderItemList);
        Orders orders = new Orders();
        BeanUtils.copyProperties(orderRequest, orders);
        orders.setCreateTime(new Date());
        orders.setUpdateTime(new Date());
        orders.setOrderCode(OrderCodeUtil.getOrderNo());
        ordersDao.insert(orders);
        OrderShip orderShip = new OrderShip();
        orderShip.setOrderId(orders.getId());
        orderShip.setOrderItemId(orderItem.getId());
        return orderShipDao.insert(orderShip);
    }

    @Override
    public Integer updateOrderById(UpdateOrderRequest request) {
        Orders orders = new Orders();
        BeanUtils.copyProperties(request, orders);
        return ordersDao.update(orders);
    }

    @Override
    public OrdersResponseList getOrdersByUserId(Long userId, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        OrdersResponseList ordersResponseList = new OrdersResponseList();
        List<Orders> ordersDaoList = ordersDao.getOrdersByUserId(userId);
        PageInfo<Orders> pageInfo = new PageInfo<>(ordersDaoList);
        //返回的数据集合
        List<OrderResponse> orderResponseList = new ArrayList<>();
        for (Orders order : pageInfo.getList()) {
            OrderResponse orderResponse = new OrderResponse();
            BeanUtils.copyProperties(order, orderResponse);
            OrderShip orderShip = orderShipDao.selectOrderItemByOrderId(order.getId());
            OrderItem orderItem = orderItemDao.selectOrderItemById(orderShip.getOrderItemId());
            orderResponse.setGoodId(orderItem.getGoodId());
            orderResponse.setItemNum(orderItem.getItemNum());
            orderResponse.setCreateTime(DateTimeUtil.getDateTimeToString(order.getCreateTime(),DateTimeUtil.DATETIME_FORMAT_YYYY_MM_DD_HH_MM));
            orderResponse.setGood(goodsDao.findGoodsById(orderItem.getId()));
            orderResponse.setUser(userDao.selectUser(order.getUserId()));
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
        PageHelper.startPage(pageNumber, pageSize);
        OrdersResponseList ordersResponseList = new OrdersResponseList();
        List<Orders> ordersDaoList = ordersDao.getAllOrders();
        PageInfo<Orders> pageInfo = new PageInfo<>(ordersDaoList);
        //返回的数据集合
        List<OrderResponse> orderResponseList = new ArrayList<>();
        for (Orders order : pageInfo.getList()) {
            OrderResponse orderResponse = new OrderResponse();
            BeanUtils.copyProperties(order, orderResponse);
            OrderShip orderShip = orderShipDao.selectOrderItemByOrderId(order.getId());
            OrderItem orderItem = orderItemDao.selectOrderItemById(orderShip.getOrderItemId());
            orderResponse.setGoodId(orderItem.getGoodId());
            orderResponse.setItemNum(orderItem.getItemNum());
            orderResponse.setGood(goodsDao.findGoodsById(orderItem.getId()));
            orderResponse.setUser(userDao.selectUser(order.getUserId()));
            orderResponse.setCreateTime(DateTimeUtil.getDateTimeToString(order.getCreateTime(),DateTimeUtil.DATETIME_FORMAT_YYYY_MM_DD_HH_MM));
            orderResponseList.add(orderResponse);
        }

        ordersResponseList.setList(orderResponseList);
        ordersResponseList.setTotal(pageInfo.getTotal());
        return ordersResponseList;
    }

    @Override
    public OrdersResponseList getOrdersByStatus(Integer status, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        OrdersResponseList ordersResponseList = new OrdersResponseList();
        List<Orders> ordersDaoList = ordersDao.getOrdersByStatus(status);
        PageInfo<Orders> pageInfo = new PageInfo<>(ordersDaoList);
        //返回的数据集合
        List<OrderResponse> orderResponseList = new ArrayList<>();
        for (Orders order : pageInfo.getList()) {
            OrderResponse orderResponse = new OrderResponse();
            BeanUtils.copyProperties(order, orderResponse);
            OrderShip orderShip = orderShipDao.selectOrderItemByOrderId(order.getId());
            OrderItem orderItem = orderItemDao.selectOrderItemById(orderShip.getOrderItemId());
            orderResponse.setGoodId(orderItem.getGoodId());
            orderResponse.setItemNum(orderItem.getItemNum());
            orderResponse.setGood(goodsDao.findGoodsById(orderItem.getId()));
            orderResponse.setUser(userDao.selectUser(order.getUserId()));
            orderResponse.setCreateTime(DateTimeUtil.getDateTimeToString(order.getCreateTime(),DateTimeUtil.DATETIME_FORMAT_YYYY_MM_DD_HH_MM));
            orderResponseList.add(orderResponse);
        }

        ordersResponseList.setList(orderResponseList);
        ordersResponseList.setTotal(pageInfo.getTotal());
        return ordersResponseList;
    }

    @Override
    public OrdersResponseList getOrdersByStatusAndUserId(Long userId, Integer status, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber, pageSize);
        OrdersResponseList ordersResponseList = new OrdersResponseList();
        List<Orders> ordersDaoList = ordersDao.getOrdersByStatusAndUserId(userId, status);
        PageInfo<Orders> pageInfo = new PageInfo<>(ordersDaoList);
        //返回的数据集合
        List<OrderResponse> orderResponseList = new ArrayList<>();
        for (Orders order : pageInfo.getList()) {
            OrderResponse orderResponse = new OrderResponse();
            BeanUtils.copyProperties(order, orderResponse);
            OrderShip orderShip = orderShipDao.selectOrderItemByOrderId(order.getId());
            OrderItem orderItem = orderItemDao.selectOrderItemById(orderShip.getOrderItemId());
            orderResponse.setGoodId(orderItem.getGoodId());
            orderResponse.setItemNum(orderItem.getItemNum());
            orderResponse.setGood(goodsDao.findGoodsById(orderItem.getId()));
            orderResponse.setUser(userDao.selectUser(order.getUserId()));
            orderResponse.setCreateTime(DateTimeUtil.getDateTimeToString(order.getCreateTime(),DateTimeUtil.DATETIME_FORMAT_YYYY_MM_DD_HH_MM));
            orderResponseList.add(orderResponse);
        }

        ordersResponseList.setList(orderResponseList);
        ordersResponseList.setTotal(pageInfo.getTotal());
        return ordersResponseList;
    }
}
