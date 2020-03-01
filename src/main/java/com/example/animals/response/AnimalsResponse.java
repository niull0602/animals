package com.example.animals.response;

import com.example.animals.bo.ImgBo;
import lombok.Data;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/2/20
 * @Description:小冯同学写点注释吧！
 */
@Data
public class AnimalsResponse {
    private Long id;

    private String animalName;

    private String animalImg;

    private List<ImgBo> imgUrls;

    private String animalColor;

    private String animalSex;

    private String aninalDesc;

    private Long typeId;
}
