package com.example.animals.controller;

import com.example.animals.common.SzpJsonResult;
import com.example.animals.pojo.Animals;
import com.example.animals.request.AddAnimalRequest;
import com.example.animals.response.AnimalsResponse;
import com.example.animals.response.AnimalsResponseList;
import com.example.animals.service.AnimalService;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation("修改动物")
    @PutMapping(value = "update/animal")
    public SzpJsonResult<Integer> updateAnimalById(@RequestBody Animals animals){
        return SzpJsonResult.ok(animalService.updateAnimalById(animals));
    }

    /**
     * 管理员查看所有动物
     * @param pageNumber
     * @param size
     * @return
     */
    @ApiOperation("查看所有动物")
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
    @ApiOperation("用户首页展示的动物")
    @GetMapping(value = "select/all/animal/user")
    public SzpJsonResult<AnimalsResponseList> selectAllAnimalToUser(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber,
                                                              @RequestParam(value = "pageSize",defaultValue = "10")Integer size){
        return SzpJsonResult.ok(animalService.selectAllAnimalToUser(pageNumber,size));
    }

    @GetMapping(value = "user/select/animal/{id}")
    public SzpJsonResult<AnimalsResponse> selectAnimalById(@PathVariable(value = "id") Long id){
        return SzpJsonResult.ok(animalService.selectAnimalById(id));
    }

    @GetMapping(value = "find/aninal/keyword")
    public SzpJsonResult<AnimalsResponseList> findAnimalByKeyword(@RequestParam(value = "keyword",defaultValue = "",required = false) String keyWord,
                                                                  @RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber,
                                                                  @RequestParam(value = "pageSize",defaultValue = "10")Integer size){
        return SzpJsonResult.ok(animalService.findAnimalByKeyword(keyWord,pageNumber,size));
    }
    @ApiOperation("根据分类查询")
    @GetMapping(value = "get/animals/typeId")
    public SzpJsonResult<AnimalsResponseList> getAnimalsByTypeId(@RequestParam(value = "typeId") Long  typeId,
                                                                 @RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber,
                                                                 @RequestParam(value = "pageSize",defaultValue = "10")Integer size){
        return SzpJsonResult.ok(animalService.getAnimalsByTypeId(typeId,pageNumber,size));
    }

}
