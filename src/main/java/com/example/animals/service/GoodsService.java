package com.example.animals.service;

import com.example.animals.pojo.Goods;
import com.example.animals.request.AddGoodRequest;
import com.example.animals.request.GoodsRequest;
import com.example.animals.response.GoodResponse;
import com.example.animals.response.SelectGoodResponse;

import java.util.List;

/**
 * Created by lemon on 2020-02-18 22:19.
 */
public interface GoodsService {
    SelectGoodResponse searchGoods(String goodsName, Integer size, Integer page);

    Integer upateGoods(GoodsRequest goodsRequest);

    Integer addGood(AddGoodRequest addGoodRequest);

    Integer deleteGoodById(Long id);

    Integer deleteGoodByIds(List<Long> ids);

    SelectGoodResponse findAllGoods(Integer size, Integer page);

    SelectGoodResponse findGoodsByTypeId(Long typeId, Integer size, Integer page);

    GoodResponse findGoodById(Long id);
}
