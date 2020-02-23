package com.example.animals.service;

import com.example.animals.request.AddAnimalRequest;
import com.example.animals.response.AnimalsResponseList;

/**
 * @Author:Fengxutong
 * @Date:2020/2/20
 * @Description:小冯同学写点注释吧！
 */
public interface AnimalService {

    Integer addAnimal(AddAnimalRequest addAnimalRequest);

    Integer deleteAnimal(Integer animalId);

    Integer updateAnimalStatusById(Long animalId, Integer status);

    AnimalsResponseList selectAllAnimal(Integer pageNumber, Integer size);

    AnimalsResponseList selectAllAnimal(String animalRequest, Integer pageNumber, Integer size);


}
