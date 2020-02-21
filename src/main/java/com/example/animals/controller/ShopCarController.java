package com.example.animals.controller;

import com.example.animals.common.SzpJsonResult;
import com.example.animals.request.AddShopCarRequest;
import com.example.animals.request.SelectShopCarRequest;
import com.example.animals.request.UpdateShopCarRequest;
import com.example.animals.response.ShopCarResponseList;
import com.example.animals.service.ShopCarService;
import com.example.animals.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lemon on 2020-02-19 16:37.
 */
@RestController
public class ShopCarController {
    @Autowired
    private ShopCarService shopCarService;

    @PostMapping(value = "add/shopcar")
    public SzpJsonResult<Integer> addShopCar(@RequestBody AddShopCarRequest shopCarRequest) {
        return SzpJsonResult.ok(shopCarService.addShopCar(shopCarRequest));
    }

    @PutMapping(value = "update/shopcar")
    public SzpJsonResult<Integer> updateShopCar(@RequestBody UpdateShopCarRequest updateShopCarRequest){
        return SzpJsonResult.ok(shopCarService.updateShopCar(updateShopCarRequest));
    }

    @DeleteMapping(value = "delete/shopcar/{id}")
    public SzpJsonResult<Integer> deleteShopCarById(@PathVariable(value = "id")Long id){
        return SzpJsonResult.ok(shopCarService.deleteShopCarById(id));
    }

    @DeleteMapping(value = "delete/shopcar/ids")
    public SzpJsonResult<Integer> deleteShopCarByIds(@RequestParam(value = "ids") List<Long> ids){
        return SzpJsonResult.ok(shopCarService.deleteShopCarByIds(ids));
    }

    @PostMapping(value = "select/shopcar/userId")
    public SzpJsonResult<ShopCarResponseList> getShopCarListByUserId(@RequestBody SelectShopCarRequest shopCarRequest){
        String token = shopCarRequest.getToken();
        if (JwtUtil.getPhoneNumber(token)==null){
            return SzpJsonResult.errorMsg("没有登录！");
        }
        return SzpJsonResult.ok(shopCarService.selectShopCarByUserId(shopCarRequest));
    }


}
