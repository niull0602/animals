package com.example.animals.service.impl;

import com.example.animals.bo.ImgBo;
import com.example.animals.constant.AnimalsConstant;
import com.example.animals.dao.AdoptDao;
import com.example.animals.dao.AnimalDao;
import com.example.animals.dao.TypeDao;
import com.example.animals.dao.UserDao;
import com.example.animals.pojo.Adopt;
import com.example.animals.pojo.Animals;
import com.example.animals.pojo.Type;
import com.example.animals.pojo.User;
import com.example.animals.request.AddAnimalRequest;
import com.example.animals.response.AnimalsResponse;
import com.example.animals.response.AnimalsResponseList;
import com.example.animals.service.AnimalService;
import com.example.animals.utils.DateTimeUtil;
import com.example.animals.utils.JsonUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @Author:Fengxutong
 * @Date:2020/2/20
 * @Description:小冯同学写点注释吧！
 */
@Service
public class AnimalServiceImpl implements AnimalService {
    @Autowired
    private TypeDao typeDao;
    @Autowired
    private AnimalDao animalDao;
    @Autowired
    private AdoptDao adoptDao;
    @Autowired
    private UserDao userDao;

    @Override
    public Integer addAnimal(AddAnimalRequest addAnimalRequest) {
        Animals animals = new Animals();
        BeanUtils.copyProperties(addAnimalRequest,animals);
        animals.setRegistTime(new Date());
        return animalDao.addAnimal(animals);
    }

    @Override
    public Integer deleteAnimal(Long animalId) {
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
        PageHelper.startPage(pageNumber,size);
        List<Animals> list = animalDao.selectAll();
        PageInfo<Animals> pageInfo = new PageInfo<>(list);
        AnimalsResponseList animalsResponseList = new AnimalsResponseList();
        List<AnimalsResponse> animalsResponses = new ArrayList<>();
        for (Animals animals:pageInfo.getList()) {
            AnimalsResponse animalsResponse = new AnimalsResponse();
            BeanUtils.copyProperties(animals,animalsResponse);
            Type typeById = typeDao.getTypeById(animals.getTypeId());
            animalsResponse.setTypeName(typeById.getTypeName());
            if (animals.getStatus()== AnimalsConstant.ANIMAL_STATUS){
                Adopt adopt = adoptDao.getUserByAnimalId(animals.getId());
                if (null!=adopt) {
                    User user = userDao.selectUser(adopt.getUserId());
                    animalsResponse.setUser(user);
                    animalsResponse.setAdoptTime(DateTimeUtil.getDateTimeToString(adopt.getCreateTime(), DateTimeUtil.DATETIME_FORMAT_YYYY_MM_DD_HH_MM));
                }
            }
            animalsResponses.add(animalsResponse);
        }
        animalsResponseList.setAnimalsResponse(animalsResponses);
        animalsResponseList.setSize(pageInfo.getTotal());
        return animalsResponseList;
    }

    //用户根据宠物名称或者颜色查询
    @Override
    public AnimalsResponseList selectAllAnimal(String animalRequest, Integer pageNumber, Integer size) {
        PageHelper.startPage(pageNumber,size);
        List<Animals> list = animalDao.selectAllAnimal(animalRequest);
        PageInfo<Animals> pageInfo = new PageInfo<>(list);
        AnimalsResponseList animalsResponseList = new AnimalsResponseList();
        List<AnimalsResponse> animalsResponses = new ArrayList<>();
        for (Animals animals:pageInfo.getList()) {
            AnimalsResponse animalsResponse = new AnimalsResponse();
            BeanUtils.copyProperties(animals,animalsResponse);
            Type typeById = typeDao.getTypeById(animals.getTypeId());
            animalsResponse.setTypeName(typeById.getTypeName());
            animalsResponses.add(animalsResponse);
        }
        animalsResponseList.setAnimalsResponse(animalsResponses);
        animalsResponseList.setSize(pageInfo.getTotal());
        return animalsResponseList;
    }

    @Override
    public AnimalsResponseList selectAllAnimalToUser(Integer pageNumber,Integer size) {
        PageHelper.startPage(pageNumber,size);
        List<Animals> list = animalDao.selectAllAnimal(0);
        PageInfo<Animals> pageInfo = new PageInfo<>(list);
        AnimalsResponseList animalsResponseList = new AnimalsResponseList();
        List<AnimalsResponse> animalsResponses = new ArrayList<>();
        for (Animals animals:pageInfo.getList()) {
            AnimalsResponse animalsResponse = new AnimalsResponse();
            BeanUtils.copyProperties(animals,animalsResponse);
            Type typeById = typeDao.getTypeById(animals.getTypeId());
            animalsResponse.setTypeName(typeById.getTypeName());
            animalsResponses.add(animalsResponse);
        }
        animalsResponseList.setAnimalsResponse(animalsResponses);
        animalsResponseList.setSize(pageInfo.getTotal());
        return animalsResponseList;
    }

    @Override
    public AnimalsResponse selectAnimalById(Long id) {
        Animals animals = animalDao.selectAnimalById(id);
        AnimalsResponse animalsResponse = new AnimalsResponse();
        BeanUtils.copyProperties(animals,animalsResponse);
        return animalsResponse;
    }

    @Override
    public AnimalsResponseList findAnimalByKeyword(String keyWord, Integer pageNumber, Integer size) {
        PageHelper.startPage(pageNumber,size);
        List<Animals> list = animalDao.findAnimalsByKeyWord(keyWord);
        PageInfo<Animals> pageInfo = new PageInfo<>(list);
        AnimalsResponseList animalsResponseList = new AnimalsResponseList();
        List<AnimalsResponse> animalsResponses = new ArrayList<>();
        for (Animals animals:pageInfo.getList()) {
            AnimalsResponse animalsResponse = new AnimalsResponse();
            BeanUtils.copyProperties(animals,animalsResponse);
            Type typeById = typeDao.getTypeById(animals.getTypeId());
            animalsResponse.setTypeName(typeById.getTypeName());
            if (animals.getStatus()== AnimalsConstant.ANIMAL_STATUS){
                Adopt adopt = adoptDao.getUserByAnimalId(animals.getId());
                if (null!=adopt) {
                    User user = userDao.selectUser(adopt.getUserId());
                    animalsResponse.setUser(user);
                    animalsResponse.setAdoptTime(DateTimeUtil.getDateTimeToString(adopt.getCreateTime(), DateTimeUtil.DATETIME_FORMAT_YYYY_MM_DD_HH_MM));
                }
            }
            animalsResponses.add(animalsResponse);
        }
        animalsResponseList.setAnimalsResponse(animalsResponses);
        animalsResponseList.setSize(pageInfo.getTotal());
        return animalsResponseList;
    }

    @Override
    public Integer updateAnimalById(Animals animals) {
        return animalDao.updateAnimalById(animals);
    }

    @Override
    public AnimalsResponseList getAnimalsByTypeId(Long typeId, Integer pageNumber, Integer size) {
        PageHelper.startPage(pageNumber,size);
        List<Animals> list = animalDao.getAnimalsByTypeId(typeId);
        PageInfo<Animals> pageInfo = new PageInfo<>(list);
        AnimalsResponseList animalsResponseList = new AnimalsResponseList();
        List<AnimalsResponse> animalsResponses = new ArrayList<>();
        for (Animals animals:pageInfo.getList()) {
            AnimalsResponse animalsResponse = new AnimalsResponse();
            BeanUtils.copyProperties(animals,animalsResponse);
            Type typeById = typeDao.getTypeById(animals.getTypeId());
            animalsResponse.setTypeName(typeById.getTypeName());
            animalsResponses.add(animalsResponse);
        }
        animalsResponseList.setAnimalsResponse(animalsResponses);
        animalsResponseList.setSize(pageInfo.getTotal());
        return animalsResponseList;
    }
}
