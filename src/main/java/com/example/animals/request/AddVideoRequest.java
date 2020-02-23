package com.example.animals.request;

import lombok.Data;

import java.util.Date;

/**
 * @Author:Fengxutong
 * @Date:2020/2/21
 * @Description:小冯同学写点注释吧！
 */
@Data
public class AddVideoRequest {
    private Long userId;

    private String videoUrl;

    private String address;

    private Integer adoptStatus;

}
