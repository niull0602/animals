package com.example.animals.service.impl;

import com.example.animals.dao.TypeDao;
import com.example.animals.pojo.Type;
import com.example.animals.request.AddTypeRequest;
import com.example.animals.response.AnimalsTypeResponse;
import com.example.animals.response.GoodTypeResponse;
import com.example.animals.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lemon on 2020-02-19 11:50.
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeDao typeDao;

    @Override
    public AnimalsTypeResponse getAnimalsType() {
        List<Type> list = typeDao.getAnimalsType();
        AnimalsTypeResponse animalsTypeResponse = new AnimalsTypeResponse();
        animalsTypeResponse.setList(list);
        return animalsTypeResponse;
    }

    @Override
    public GoodTypeResponse getGoodsType(Long typeId) {
        Type type = typeDao.getTypeById(typeId);
        String code = type.getCode();
        List<Type> goodsType = typeDao.getGoodsType(code);
        GoodTypeResponse goodTypeResponse = new GoodTypeResponse();
        goodTypeResponse.setList(goodsType);
        return goodTypeResponse;
    }

    @Override
    public Integer add(AddTypeRequest request) {
        Type type = new Type();
        BeanUtils.copyProperties(request,type);
        return typeDao.insert(type);
    }

    @Override
    public Integer deleteTpyeById(Long id) {
        return typeDao.deleteTpyeById(id);
    }
}
