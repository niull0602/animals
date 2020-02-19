package com.example.animals.controller;

import com.example.animals.common.SzpJsonResult;
import com.example.animals.pojo.Goods;
import com.example.animals.request.AddGoodRequest;
import com.example.animals.request.GoodsRequest;
import com.example.animals.response.GoodResponse;
import com.example.animals.response.SelectGoodResponse;
import com.example.animals.service.GoodsService;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

/**
 * Created by lemon on 2020-02-18 22:22.
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @PostMapping(value = "/add")
    public SzpJsonResult<Integer> addGood(@RequestBody AddGoodRequest addGoodRequest){
        return SzpJsonResult.ok(goodsService.addGood(addGoodRequest));
    }

    @DeleteMapping(value = "/delete/{id}")
    public SzpJsonResult<Integer> deleteById(@PathVariable(value = "id") Long id){
        return SzpJsonResult.ok(goodsService.deleteGoodById(id));
    }

    @DeleteMapping(value = "/delete/ids")
    public SzpJsonResult<Integer> deleteByIds(List<Long> ids){
        return SzpJsonResult.ok(goodsService.deleteGoodByIds(ids));
    }

    @PutMapping(value = "/update")
    public SzpJsonResult<Integer> updateGoods(@RequestBody GoodsRequest goodsRequest){
        return SzpJsonResult.ok(goodsService.upateGoods(goodsRequest));
    }

    @GetMapping(value = "/search/keywords")
    public SzpJsonResult<SelectGoodResponse> search(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                    @RequestParam(value = "size",defaultValue = "10")Integer size,
                                                    @RequestParam(value = "keywords",defaultValue = "",required = false)String keyWords){
        return SzpJsonResult.ok(goodsService.searchGoods(keyWords,size,page));
    }

    /**
     * 管理员查看商品信息
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/find/all/admin")
    public SzpJsonResult<SelectGoodResponse> findAllGoodsToAdmin(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                                 @RequestParam(value = "size",defaultValue = "10")Integer size) {
        return SzpJsonResult.ok(goodsService.findAllGoods(size, page));
    }

    /**
     * 通过分类查找
     * @param page
     * @param size
     * @param typeId
     * @return
     */
    @GetMapping(value = "/find/goods/{typeId}")
    public SzpJsonResult<SelectGoodResponse> findGoodsByTypeId(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                               @RequestParam(value = "size",defaultValue = "10")Integer size,
                                                               @PathVariable(value = "typeId")Long typeId) {
        return SzpJsonResult.ok(goodsService.findGoodsByTypeId(typeId,size, page));
    }

    /**
     * 用户查看商品信息
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/find/all/user")
    public SzpJsonResult<SelectGoodResponse> findAllGoodsToUser(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                                @RequestParam(value = "size",defaultValue = "10")Integer size) {
        SelectGoodResponse goodsResponse = goodsService.findAllGoods(size, page);
        List<Goods> goodsList = goodsResponse.getGoodsList();
        Collections.shuffle(goodsList);
        goodsResponse.setGoodsList(goodsList);
        return SzpJsonResult.ok(goodsResponse);
    }

    @GetMapping("find/by/id")
    public SzpJsonResult<GoodResponse> findGoodsById(@PathVariable(value = "id")Long id){
        return SzpJsonResult.ok(goodsService.findGoodById(id));
    }

}
