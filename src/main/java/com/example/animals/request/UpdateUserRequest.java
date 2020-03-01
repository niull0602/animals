package com.example.animals.request;

import com.example.animals.pojo.User;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.util.Date;

/**
 * @Author:Fengxutong
 * @Date:2020/2/19
 * @Description:小冯同学写点注释吧！
 */
@Data
public class UpdateUserRequest {
    private Long id;

    private Long phoneNumber;

    private String password;

    private String nickName;


    private String imgUrl;

    /**
     * 真实姓名
     */
    private String name;

    private Integer age;

    private String sex;

    private String address;

    /**
     * 余额
     */
    private Double money;

}
