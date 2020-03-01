package com.example.animals.controller;

import com.example.animals.common.SzpJsonResult;
import com.example.animals.request.AddTypeRequest;
import com.example.animals.response.AnimalsTypeResponse;
import com.example.animals.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lemon on 2020-02-19 11:49.
 */
@RestController
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping(value = "get/animals/type")
    public SzpJsonResult<AnimalsTypeResponse> getAnimalsType(){
        return SzpJsonResult.ok(typeService.getAnimalsType());
    }

    @GetMapping(value = "get/goods/type/{typeId}")
    public SzpJsonResult<AnimalsTypeResponse> getGoodsType(@PathVariable(value = "typeId") Long typeId){
        return SzpJsonResult.ok(typeService.getGoodsType(typeId));
    }

    @PostMapping(value = "add/type")
    public SzpJsonResult<Integer> addTpye(@RequestBody AddTypeRequest request){
        return SzpJsonResult.ok(typeService.add(request));
    }

    @DeleteMapping(value = "delete/type/{id}")
    public SzpJsonResult<Integer> deleteTpyeById(@PathVariable(value = "id")Long id){
        return SzpJsonResult.ok(typeService.deleteTpyeById(id));
    }



}
