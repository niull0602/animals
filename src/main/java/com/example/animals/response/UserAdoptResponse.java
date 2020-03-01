package com.example.animals.response;

import lombok.Data;

import java.util.Date;

/**
 * Created by lemon on 2020-02-26 20:06.
 */
@Data
public class UserAdoptResponse {
    private Long animalId;

    private String animalName;

    private String animalImg;

    /**
     * 领养日期
     */
    private Date createTime;
}
