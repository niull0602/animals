package com.example.animals.service;

import com.example.animals.pojo.Animals;
import com.example.animals.request.AddAnimalRequest;
import com.example.animals.response.AnimalsResponse;
import com.example.animals.response.AnimalsResponseList;

/**
 * @Author:Fengxutong
 * @Date:2020/2/20
 * @Description:小冯同学写点注释吧！
 */
public interface AnimalService {

    Integer addAnimal(AddAnimalRequest addAnimalRequest);

    Integer deleteAnimal(Long animalId);

    Integer updateAnimalStatusById(Long animalId, Integer status);

    AnimalsResponseList selectAllAnimal(Integer pageNumber, Integer size);

    AnimalsResponseList selectAllAnimal(String animalRequest, Integer pageNumber, Integer size);

    AnimalsResponseList selectAllAnimalToUser(Integer pageNumber, Integer size);

    AnimalsResponse selectAnimalById(Long id);

    AnimalsResponseList findAnimalByKeyword(String keyWord, Integer pageNumber, Integer size);

    Integer updateAnimalById(Animals animals);

    AnimalsResponseList getAnimalsByTypeId(Long typeId, Integer pageNumber, Integer size);

}
