package com.example.animals.service.impl;
import java.util.*;

import com.example.animals.bo.GoodsImgBo;
import com.example.animals.dao.GoodsDao;
import com.example.animals.pojo.Goods;
import com.example.animals.request.AddGoodRequest;
import com.example.animals.request.GoodsRequest;
import com.example.animals.response.GoodResponse;
import com.example.animals.response.SelectGoodResponse;
import com.example.animals.service.GoodsService;
import com.example.animals.utils.JsonUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * Created by lemon on 2020-02-18 22:22.
 */
@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public Integer upateGoods(GoodsRequest goodsRequest) {
        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsRequest,goods);
        goods.setUpdateTime(new Date());
        return goodsDao.updateGoods(goods);
    }

    @Override
    public Integer deleteGoodById(Long id) {
        return goodsDao.deleteGoodsById(id);
    }

    @Override
    public Integer deleteGoodByIds(List<Long> ids) {
        return goodsDao.deleteGoodsByIds(ids);
    }

    @Override
    public SelectGoodResponse searchGoods(String goodsName, Integer size, Integer page) {
        if (!StringUtils.isEmpty(goodsName)){
            PageHelper.startPage(page,size);
            SelectGoodResponse goodSearchResponse = new SelectGoodResponse();
            List<Goods> goodsList = goodsDao.searchGoods(goodsName);
            PageInfo<Goods> pageInfo = new PageInfo<>(goodsList);
            List<Goods> list = pageInfo.getList();
            List<GoodResponse> goodResponseList = new ArrayList<>();
            for (Goods good :list) {
                GoodResponse goodResponse = new GoodResponse();
                BeanUtils.copyProperties(good, goodResponse);
                String goodImgs = good.getGoodImgs();
                HashMap hashMap = JsonUtils.jsonToPoJo(goodImgs, HashMap.class);
                List<GoodsImgBo> goodsImgBos = new ArrayList<>();
                Set<String> keySet = hashMap.keySet();
                for (String key : keySet) {
                    GoodsImgBo goodsImgBo = new GoodsImgBo();
                    String imgUrl = hashMap.get(key).toString();
                    goodsImgBo.setImgUUID(key);
                    goodsImgBo.setImgUrl(imgUrl);
                    goodsImgBos.add(goodsImgBo);
                }
                goodResponse.setGoodsImgBoList(goodsImgBos);
                goodResponseList.add(goodResponse);
            }
            goodSearchResponse.setGoodsList(goodResponseList);
            goodSearchResponse.setTotal(pageInfo.getTotal());
            return goodSearchResponse;
        }
        else {
            PageHelper.startPage(page,size);
            SelectGoodResponse goodSearchResponse = new SelectGoodResponse();
            List<Goods> goodsList = goodsDao.selectAll();
            PageInfo<Goods> pageInfo = new PageInfo<>(goodsList);
            List<Goods> list = pageInfo.getList();
            List<GoodResponse> goodResponseList = new ArrayList<>();
            for (Goods good :list) {
                GoodResponse goodResponse = new GoodResponse();
                BeanUtils.copyProperties(good, goodResponse);
                String goodImgs = good.getGoodImgs();
                HashMap hashMap = JsonUtils.jsonToPoJo(goodImgs, HashMap.class);
                List<GoodsImgBo> goodsImgBos = new ArrayList<>();
                Set<String> keySet = hashMap.keySet();
                for (String key : keySet) {
                    GoodsImgBo goodsImgBo = new GoodsImgBo();
                    String imgUrl = hashMap.get(key).toString();
                    goodsImgBo.setImgUUID(key);
                    goodsImgBo.setImgUrl(imgUrl);
                    goodsImgBos.add(goodsImgBo);
                }
                goodResponse.setGoodsImgBoList(goodsImgBos);
                goodResponseList.add(goodResponse);
            }
            goodSearchResponse.setGoodsList(goodResponseList);
            goodSearchResponse.setTotal(pageInfo.getTotal());
            return goodSearchResponse;
        }
    }

    @Override
    public SelectGoodResponse findAllGoods(Integer size, Integer page) {
        PageHelper.startPage(page,size);
        SelectGoodResponse goodSearchResponse = new SelectGoodResponse();
        List<Goods> goodsList = goodsDao.selectAll();
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsList);
        List<Goods> list = pageInfo.getList();
        List<GoodResponse> goodResponseList = new ArrayList<>();
        for (Goods good :list) {
            GoodResponse goodResponse = new GoodResponse();
            BeanUtils.copyProperties(good, goodResponse);
            String goodImgs = good.getGoodImgs();
            HashMap hashMap = JsonUtils.jsonToPoJo(goodImgs, HashMap.class);
            List<GoodsImgBo> goodsImgBos = new ArrayList<>();
            Set<String> keySet = hashMap.keySet();
            for (String key : keySet) {
                GoodsImgBo goodsImgBo = new GoodsImgBo();
                String imgUrl = hashMap.get(key).toString();
                goodsImgBo.setImgUUID(key);
                goodsImgBo.setImgUrl(imgUrl);
                goodsImgBos.add(goodsImgBo);
            }
            goodResponse.setGoodsImgBoList(goodsImgBos);
            goodResponseList.add(goodResponse);
        }
        goodSearchResponse.setGoodsList(goodResponseList);
        goodSearchResponse.setTotal(pageInfo.getTotal());
        return goodSearchResponse;
    }

    @Override
    public SelectGoodResponse findGoodsByTypeId(Long typeId, Integer size, Integer page) {
        PageHelper.startPage(page,size);
        SelectGoodResponse goodSearchResponse = new SelectGoodResponse();
        List<Goods> goodsList = goodsDao.findGoodsByTypeId(typeId);
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsList);
        List<Goods> list = pageInfo.getList();
        List<GoodResponse> goodResponseList = new ArrayList<>();
        for (Goods good :list) {
            GoodResponse goodResponse = new GoodResponse();
            BeanUtils.copyProperties(good, goodResponse);
            String goodImgs = good.getGoodImgs();
            HashMap hashMap = JsonUtils.jsonToPoJo(goodImgs, HashMap.class);
            List<GoodsImgBo> goodsImgBos = new ArrayList<>();
            Set<String> keySet = hashMap.keySet();
            for (String key : keySet) {
                GoodsImgBo goodsImgBo = new GoodsImgBo();
                String imgUrl = hashMap.get(key).toString();
                goodsImgBo.setImgUUID(key);
                goodsImgBo.setImgUrl(imgUrl);
                goodsImgBos.add(goodsImgBo);
            }
            goodResponse.setGoodsImgBoList(goodsImgBos);
            goodResponseList.add(goodResponse);
        }
        goodSearchResponse.setGoodsList(goodResponseList);
        goodSearchResponse.setTotal(pageInfo.getTotal());
        return goodSearchResponse;
    }

    @Override
    public GoodResponse findGoodById(Long id) {
        Goods good = goodsDao.findGoodsById(id);
        GoodResponse goodResponse = new GoodResponse();
        BeanUtils.copyProperties(good, goodResponse);
        String goodImgs = good.getGoodImgs();
        HashMap hashMap = JsonUtils.jsonToPoJo(goodImgs, HashMap.class);
        List<GoodsImgBo> goodsImgBos = new ArrayList<>();
        Set<String> keySet = hashMap.keySet();
        for (String key : keySet) {
            GoodsImgBo goodsImgBo = new GoodsImgBo();
            String imgUrl = hashMap.get(key).toString();
            goodsImgBo.setImgUUID(key);
            goodsImgBo.setImgUrl(imgUrl);
            goodsImgBos.add(goodsImgBo);
        }
        goodResponse.setGoodsImgBoList(goodsImgBos);
        return goodResponse;
    }

    @Override
    public List<Goods> findGoodsByIds(List<Long> ids) {
        return goodsDao.selectGoodsByIds(ids);
    }

    @Override
    public Integer addGood(AddGoodRequest addGoodRequest) {
        Goods goods = new Goods();
        BeanUtils.copyProperties(addGoodRequest,goods);
        List<String> goodsImgBoList = addGoodRequest.getGoodsImgBoList();
        if (!CollectionUtils.isEmpty(goodsImgBoList)){
            HashMap<String,String> hashMap=new HashMap<>();
            for (String s : goodsImgBoList) {
                String uuid= UUID.randomUUID().toString();
                hashMap.put(uuid,s);
            }
            String json = JsonUtils.objectToJson(hashMap);
            log.info("GoodImgs-{}",json);
            goods.setGoodImgs(json);
        }
        goods.setCreateTime(new Date());
        goods.setUpdateTime(new Date());
        return goodsDao.insertGoods(goods);
    }
}
