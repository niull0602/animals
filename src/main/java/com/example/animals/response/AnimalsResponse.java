package com.example.animals.response;

import com.example.animals.pojo.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


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

    private String animalColor;

    private String animalSex;
    @ApiModelProperty(example = "0",value = "养状态  0：待领养  1：领养 ")
    private Integer status;

    private String aninalDesc;

    private Long typeId;

    private String typeName;

    private User user;
    @ApiModelProperty(value = "领养日期")
    private String adoptTime;


}
