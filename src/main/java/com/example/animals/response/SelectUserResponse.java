package com.example.animals.response;

import com.example.animals.pojo.User;
import lombok.Data;

import java.util.List;

/**
 * Created by NiuLilu on 2020-05-22 11:12.
 */
@Data
public class SelectUserResponse {
    private List<User> list;
    private Long total;
}
