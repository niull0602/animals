package com.example.animals.service.impl;

import com.example.animals.dao.ShopCarDao;
import com.example.animals.pojo.Goods;
import com.example.animals.pojo.ShopCar;
import com.example.animals.request.AddShopCarRequest;
import com.example.animals.request.SelectShopCarRequest;
import com.example.animals.request.ShopCarRequest;
import com.example.animals.request.UpdateShopCarRequest;
import com.example.animals.response.ShopCarResponse;
import com.example.animals.response.ShopCarResponseList;
import com.example.animals.service.GoodsService;
import com.example.animals.service.ShopCarService;
import com.example.animals.service.UserService;
import com.example.animals.utils.JwtUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lemon on 2020-02-20 13:09.
 */
@Service
public class ShopCarServiceImpl implements ShopCarService {
    @Autowired
    private ShopCarDao shopCarDao;
    @Autowired
    private UserService userService;
    @Autowired
    private GoodsService goodsService;

    @Override
    public Integer addShopCar(AddShopCarRequest shopCarRequest) {
        if (shopCarRequest.getToken() == null) {
            return 0;
        }else {
            Long phoneNumber = userService.getPhoneNumber(shopCarRequest.getToken());
            if (phoneNumber == null) {
                return 0;
            }else {
                ShopCar shopCar = new ShopCar();
                BeanUtils.copyProperties(shopCarRequest,shopCar);
                return shopCarDao.insert(shopCar);
            }
        }
    }

    @Override
    public Integer deleteShopCarById(Long id) {
        return shopCarDao.deleteShopCarById(id);
    }

    @Override
    public Integer deleteShopCarByIds(List<Long> ids) {
        return shopCarDao.deleteShopCarByIds(ids);
    }

    @Override
    public Integer updateShopCar(UpdateShopCarRequest shopCarRequest) {
        List<ShopCarRequest> list = shopCarRequest.getList();
        List<ShopCar> shopCarList = new ArrayList<>();
        for (ShopCarRequest request:list){
            ShopCar shopCar = new ShopCar();
            BeanUtils.copyProperties(request, shopCar);
            shopCarList.add(shopCar);
        }
        return shopCarDao.updateByList(shopCarList);
    }

    @Override
    public ShopCarResponseList selectShopCarByUserId(SelectShopCarRequest shopCarRequest) {
        Long userId = shopCarRequest.getUserId();
        Integer pageNumber = shopCarRequest.getPageNumber();
        Integer pageSize = shopCarRequest.getPageSize();
        ShopCarResponseList shopCarResponseList = new ShopCarResponseList();
        List<ShopCarResponse> shopList = new ArrayList<>();
        PageHelper.startPage(pageNumber,pageSize);
        List<ShopCar> shopCarList = shopCarDao.selectShopCarByUserId(userId);
        PageInfo<ShopCar> pageInfo = new PageInfo<>(shopCarList);
        List<ShopCar> list = pageInfo.getList();
        ArrayList<Long> goodsIds = new ArrayList<>();
        for (ShopCar shopCar : list) {
            goodsIds.add(shopCar.getGoodId());
        }
        List<Goods> goodsList = goodsService.findGoodsByIds(goodsIds);
        for (int i = 0; i < list.size() ;  i++) {
            ShopCarResponse shopCarResponse = new ShopCarResponse();
            BeanUtils.copyProperties(list.get(i),shopCarResponse);
            BeanUtils.copyProperties(goodsList.get(i),shopCarResponse);
            shopList.add(shopCarResponse);
        }
        shopCarResponseList.setList(shopList);
        shopCarResponseList.setTotal(pageInfo.getTotal());
        return shopCarResponseList;
    }
}
