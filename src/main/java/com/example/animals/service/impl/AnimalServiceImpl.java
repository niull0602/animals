package com.example.animals.service.impl;

import com.example.animals.bo.ImgBo;
import com.example.animals.dao.AnimalDao;
import com.example.animals.pojo.Animals;
import com.example.animals.request.AddAnimalRequest;
import com.example.animals.response.AnimalsResponse;
import com.example.animals.response.AnimalsResponseList;
import com.example.animals.service.AnimalService;
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
    private AnimalDao animalDao;

    @Override
    public Integer addAnimal(AddAnimalRequest addAnimalRequest) {
        Animals animals = new Animals();
        BeanUtils.copyProperties(addAnimalRequest,animals);
        List<String> animalImgs = addAnimalRequest.getAnimalImgs();
        if (!CollectionUtils.isEmpty(animalImgs)) {
            HashMap<String, String> hashMap = new HashMap<>();
            for (String s : animalImgs) {
                String uuid = UUID.randomUUID().toString();
                hashMap.put(uuid, s);
            }
            String json = JsonUtils.objectToJson(hashMap);
            animals.setAnimalImgs(json);
        }
        animals.setRegistTime(new Date());
        animals.setStatus(0);
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
            String animalImgs = animals.getAnimalImgs();
            HashMap hashMap = JsonUtils.jsonToPoJo(animalImgs, HashMap.class);
            if (hashMap != null){
                List<ImgBo> imgBos = new ArrayList<>();
                Set<String> keySet = hashMap.keySet();
                for (String key : keySet) {
                    ImgBo imgBo = new ImgBo();
                    String imgUrl = hashMap.get(key).toString();
                    imgBo.setImgUUID(key);
                    imgBo.setImgUrl(imgUrl);
                    imgBos.add(imgBo);
                }
                animalsResponse.setImgUrls(imgBos);
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
            String animalImgs = animals.getAnimalImgs();
            HashMap hashMap = JsonUtils.jsonToPoJo(animalImgs, HashMap.class);
            if (hashMap != null){
                List<ImgBo> imgBos = new ArrayList<>();
                Set<String> keySet = hashMap.keySet();
                for (String key : keySet) {
                    ImgBo imgBo = new ImgBo();
                    String imgUrl = hashMap.get(key).toString();
                    imgBo.setImgUUID(key);
                    imgBo.setImgUrl(imgUrl);
                    imgBos.add(imgBo);
                }
                animalsResponse.setImgUrls(imgBos);
            }
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
            String animalImgs = animals.getAnimalImgs();
            HashMap hashMap = JsonUtils.jsonToPoJo(animalImgs, HashMap.class);
            if (hashMap != null){
                List<ImgBo> imgBos = new ArrayList<>();
                Set<String> keySet = hashMap.keySet();
                for (String key : keySet) {
                    ImgBo imgBo = new ImgBo();
                    String imgUrl = hashMap.get(key).toString();
                    imgBo.setImgUUID(key);
                    imgBo.setImgUrl(imgUrl);
                    imgBos.add(imgBo);
                }
                animalsResponse.setImgUrls(imgBos);
            }
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
        String animalImgs = animals.getAnimalImgs();
        HashMap hashMap = JsonUtils.jsonToPoJo(animalImgs, HashMap.class);
        List<ImgBo> imgBos = new ArrayList<>();
        Set<String> keySet = hashMap.keySet();
        for (String key : keySet) {
            ImgBo imgBo = new ImgBo();
            String imgUrl = hashMap.get(key).toString();
            imgBo.setImgUUID(key);
            imgBo.setImgUrl(imgUrl);
            imgBos.add(imgBo);
        }
        animalsResponse.setImgUrls(imgBos);
        return animalsResponse;
    }
}
