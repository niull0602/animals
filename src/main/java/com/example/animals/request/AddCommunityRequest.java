package com.example.animals.request;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: animals
 * @description:
 * @author: Jaysrr
 **/
@Data
public class AddCommunityRequest {

    private Long userId;

    private String content;

    /**
     * 发互动的多个图片
     */
    @ApiModelProperty(value = "多张图片")
    private List<String> imgUrlsList;

}
