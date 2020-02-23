package com.example.animals.response;

import lombok.Data;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/2/20
 * @Description:小冯同学写点注释吧！
 */
@Data
public class AnimalsResponseList {
    private List<AnimalsResponse> animalsResponse;

    private Long size;
}
