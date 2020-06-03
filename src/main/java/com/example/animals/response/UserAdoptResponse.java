package com.example.animals.response;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.util.Date;

/**
 * Created by lemon on 2020-02-26 20:06.
 */
@Data
public class UserAdoptResponse {
    @ApiModelProperty("用户id")
    private Long userId;
    @ApiModelProperty(value = "用户手机号码")
    private Long phoneNumber;
    @ApiModelProperty(value = "用户名字")
    private String name;
    @ApiModelProperty(value = "动物的id")
    private Long animalId;
    @ApiModelProperty(value = "动物名字")
    private String animalName;
    @ApiModelProperty(value = "动物图片")
    private String animalImg;

    /**
     * 领养日期
     */
    @ApiModelProperty(value = "领养日期")
    private String createTime;
}
