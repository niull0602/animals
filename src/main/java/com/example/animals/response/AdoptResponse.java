package com.example.animals.response;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Created by lemon on 2020-02-26 22:48.
 */
@Data
@ToString
public class AdoptResponse {
    private Long id;

    private Long userId;

    private Long animalId;

    private Integer evaNum;

    /**
     * 领养状态 0：正常 1：拒绝再次领养
     */
    private Integer status;

    private Date createTime;
}
