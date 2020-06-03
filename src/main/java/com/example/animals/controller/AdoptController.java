package com.example.animals.controller;

import com.example.animals.common.SzpJsonResult;
import com.example.animals.request.AddAdoptRequest;
import com.example.animals.request.AdoptRequest;
import com.example.animals.response.AdoptResponseList;
import com.example.animals.response.UserAdoptResponseList;
import com.example.animals.service.AdoptService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @program: animals
 * @description:
 * @author: Jaysrr
 * @create: 2020-02-21 17:48
 **/
@RestController
@RequestMapping("/adopt")
public class AdoptController {
    @Autowired
    private AdoptService adoptService;

    /*
    @GetMapping("/find/{id}")
    public SzpJsonResult findById(@PathVariable("id") Long id) {
        return SzpJsonResult.ok();
    }
    */

    @GetMapping("/find/animal/{animalId}")
    public SzpJsonResult<UserAdoptResponseList> findAdoptByAnimalId(@PathVariable("animalId") Long animalId,
                                                                    @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                    @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return SzpJsonResult.ok(adoptService.findAdoptByAnimalId(animalId, page, size));
    }

    /**
     * 一键查询不合法领养关系
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/find/illegal/adopt")
    public SzpJsonResult<AdoptResponseList> findIllegalAdopt(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                             @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return SzpJsonResult.ok(adoptService.findIllegalAdopt(page,size));
    }

    @ApiOperation("用户查看领养自己的动物")
    @GetMapping("/find/user/{userId}")
    public SzpJsonResult<UserAdoptResponseList> findAdoptByUserId(@PathVariable("userId") Long userId) {
        return SzpJsonResult.ok(adoptService.findAdoptByUserId(userId));
    }

    @ApiOperation("admin查看所有")
    @GetMapping("get/all")
    public SzpJsonResult<UserAdoptResponseList> adminGetAllAdopt(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                                      @RequestParam(value = "size",defaultValue = "10")Integer size) {
        return SzpJsonResult.ok(adoptService.adminGetAllAdopt(page,size));
    }
    @ApiOperation("建立领养关系")
    @PostMapping("/insert")
    public SzpJsonResult<Integer> insertAdopt(@RequestBody AddAdoptRequest addAdoptRequest) {
        return SzpJsonResult.ok(adoptService.insertAdopt(addAdoptRequest));
    }

    @PutMapping("/update")
    public SzpJsonResult<Integer> updateAdopt(@RequestBody AdoptRequest adoptRequest) {
        return SzpJsonResult.ok(adoptService.updateAdopt(adoptRequest));
    }

    @PutMapping("/update/status")
    public SzpJsonResult<Integer> updateStatus(@RequestBody AdoptRequest adoptRequest) {
        return SzpJsonResult.ok(adoptService.updateStatus(adoptRequest));
    }

}
