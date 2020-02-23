package com.example.animals.request;

import lombok.Data;

/**
 * @Author:Fengxutong
 * @Date:2020/2/20
 * @Description:小冯同学写点注释吧！
 */
@Data
public class AddAnimalRequest {

    private String animalName;

    private String animalImg;

    private String animalImgs;

    private String animalColor;

    private String animalSex;

    private String aninalDesc;

    private Integer status;

    private Long typeId;
}
