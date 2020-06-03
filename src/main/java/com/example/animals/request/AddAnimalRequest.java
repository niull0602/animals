package com.example.animals.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/2/20
 * @Description:小冯同学写点注释吧！
 */
@Data
public class AddAnimalRequest {

    private String animalName;

    private String animalImg;

    private String animalColor;

    private String animalSex;

    private String aninalDesc;
    @ApiModelProperty(value = "领养状态  0：待领养  1：领养 默认为0",example = "0")
    private Integer status=0;

    private Long typeId;
}
