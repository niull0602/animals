package com.example.animals.controller;

import com.example.animals.common.SzpJsonResult;
import com.example.animals.request.AddAnimalRequest;
import com.example.animals.response.AnimalsResponse;
import com.example.animals.response.AnimalsResponseList;
import com.example.animals.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:Fengxutong
 * @Date:2020/2/24
 * @Description:小冯同学写点注释吧！
 */
@RestController
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @PostMapping(value = "add/animal")
    public SzpJsonResult<Integer> addAnimal(@RequestBody AddAnimalRequest addAnimalRequest){
        return SzpJsonResult.ok(animalService.addAnimal(addAnimalRequest));
    }


    @DeleteMapping(value = "deleteAnimal/{id}")
    public SzpJsonResult<Integer> deleteAnimal(@PathVariable(value = "id") Long id){
        return SzpJsonResult.ok(animalService.deleteAnimal(id));
    }

    @PutMapping(value = "update/animalStatus/by/id")
    public SzpJsonResult<Integer> updateAnimalStatusById(@RequestParam(value = "animalId") Long animalId,
                                                         @RequestParam(value = "status") Integer status){
        return SzpJsonResult.ok(animalService.updateAnimalStatusById(animalId,status));
    }

    /**
     * 管理员查看所有动物
     * @param pageNumber
     * @param size
     * @return
     */
    @GetMapping(value = "select/all/animal")
    public SzpJsonResult<AnimalsResponseList> selectAllAnimal(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber,
                                                              @RequestParam(value = "pageSize",defaultValue = "10")Integer size){
        return SzpJsonResult.ok(animalService.selectAllAnimal(pageNumber,size));
    }

    /**
     * 用户首页展示的动物
     * @param pageNumber
     * @param size
     * @return
     */
    @GetMapping(value = "select/all/animal/user")
    public SzpJsonResult<AnimalsResponseList> selectAllAnimalToUser(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber,
                                                              @RequestParam(value = "pageSize",defaultValue = "10")Integer size){
        return SzpJsonResult.ok(animalService.selectAllAnimalToUser(pageNumber,size));
    }

    @GetMapping(value = "user/select/animal/{id}")
    public SzpJsonResult<AnimalsResponse> selectAnimalById(@PathVariable(value = "id") Long id){
        return SzpJsonResult.ok(animalService.selectAnimalById(id));
    }
}
