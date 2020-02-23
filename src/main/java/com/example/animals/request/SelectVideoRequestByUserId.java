package com.example.animals.request;

import lombok.Data;

/**
 * @Author:Fengxutong
 * @Date:2020/2/21
 * @Description:小冯同学写点注释吧！
 */
@Data
public class SelectVideoRequestByUserId {

    private Integer userId;

    private Integer pageNumber;

    private Integer size;
}
