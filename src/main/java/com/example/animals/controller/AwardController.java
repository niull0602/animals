package com.example.animals.controller;

import com.example.animals.common.SzpJsonResult;
import com.example.animals.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:Fengxutong
 * @Date:2020/2/24
 * @Description:小冯同学写点注释吧！
 */
@RestController
public class AwardController {
    @Autowired
    private AwardService awardService;

    @PostMapping(value = "award/by/userId/and/animalId")
    public SzpJsonResult<Integer> award(Long userId, Double money, Long animalId){
        return SzpJsonResult.ok(awardService.award(userId,money,animalId));
    }
}
