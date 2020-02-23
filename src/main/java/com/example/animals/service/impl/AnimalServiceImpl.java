package com.example.animals.service.impl;

import com.example.animals.dao.AnimalDao;
import com.example.animals.pojo.Animals;
import com.example.animals.request.AddAnimalRequest;
import com.example.animals.response.AnimalsResponse;
import com.example.animals.response.AnimalsResponseList;
import com.example.animals.service.AnimalService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/2/20
 * @Description:小冯同学写点注释吧！
 */
@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    AnimalDao animalDao;

    @Override
    public Integer addAnimal(AddAnimalRequest addAnimalRequest) {
        Animals animals = new Animals();
        BeanUtils.copyProperties(addAnimalRequest,animals);
        animals.setRegist_time(new Date());
        return animalDao.addAnimal(animals);
    }

    @Override
    public Integer deleteAnimal(Integer animalId) {
        return animalDao.deleteById(animalId);
    }

    //修改动物领养状态
    @Override
    public Integer updateAnimalStatusById(Long animalId,Integer status) {
        Animals animals = animalDao.selectAnimalById(animalId);
        animals.setStatus(status);
        return animalDao.updateAnimalStatus(animals);
    }

    //管理员查询所有宠物
    @Override
    public AnimalsResponseList selectAllAnimal(Integer pageNumber,Integer size) {
        List<Animals> list = animalDao.selectAllAnimal((long) 0);
        PageHelper.startPage(pageNumber,size);
        AnimalsResponseList animalsResponseList = new AnimalsResponseList();
        List<AnimalsResponse> animalsResponses = new ArrayList<>();
        for (Animals animals:list) {
            AnimalsResponse animalsResponse = new AnimalsResponse();
            BeanUtils.copyProperties(animals,animalsResponse);
            animalsResponses.add(animalsResponse);
        }
        PageInfo<AnimalsResponse> pageInfo = new PageInfo<>(animalsResponses);
        AnimalsResponseList animalsResponseList1 = new AnimalsResponseList();
        animalsResponseList1.setAnimalsResponse(pageInfo.getList());
        animalsResponseList1.setSize(pageInfo.getTotal());
        return animalsResponseList1;
    }

    //用户根据宠物名称或者颜色查询
    @Override
    public AnimalsResponseList selectAllAnimal(String animalRequest, Integer pageNumber, Integer size) {
        List<Animals> list = animalDao.selectAllAnimal(animalRequest);
        PageHelper.startPage(pageNumber,size);
        AnimalsResponseList animalsResponseList = new AnimalsResponseList();
        List<AnimalsResponse> animalsResponses = new ArrayList<>();
        for (Animals animals:list) {
            AnimalsResponse animalsResponse = new AnimalsResponse();
            BeanUtils.copyProperties(animals,animalsResponse);
            animalsResponses.add(animalsResponse);
        }
        PageInfo<AnimalsResponse> pageInfo = new PageInfo<>(animalsResponses);
        AnimalsResponseList animalsResponseList1 = new AnimalsResponseList();
        animalsResponseList1.setAnimalsResponse(pageInfo.getList());
        animalsResponseList1.setSize(pageInfo.getTotal());
        return animalsResponseList1;
    }


}
