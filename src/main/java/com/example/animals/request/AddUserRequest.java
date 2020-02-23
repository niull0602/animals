package com.example.animals.request;

import lombok.Data;

import java.util.Date;

/**
 * @Author:Fengxutong
 * @Date:2020/2/19
 * @Description:小冯同学写点注释吧！
 */
@Data
public class AddUserRequest {
    private Long phoneNumber;

    private String password;

    private String nickName;

    private String imgUrl;

    private String name;

    private Integer age;

    private String sex;

    private String address;

    private Double money = 0D;

    /**
     * 用户-0 管理员-1
     */
    private Short mark;
}
