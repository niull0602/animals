package com.example.animals.response;

import com.example.animals.pojo.User;
import lombok.Data;

/**
 * Created by lemon on 2020-02-23 22:58.
 */
@Data
public class LoginResponse {
    private User user;

    private String token;

    private String msg;
}
