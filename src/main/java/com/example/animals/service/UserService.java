package com.example.animals.service;

import com.example.animals.pojo.User;
import com.example.animals.request.AddUserRequest;
import com.example.animals.request.UpdateUserRequest;
import com.example.animals.response.UserResponse;

/**
 * Created by lemon on 2020-02-20 13:52.
 */
public interface UserService {
    boolean saveCode(Long phoneNumber, String code);

    boolean sendCode(Long phoneNumber, String code);

    String getCode(Long phoneNumber);

    void saveToken(Long userId) throws Exception;

    Long getUserId(String token);

    Integer addUser(AddUserRequest addUserRequest, Short mark);

    Integer deleteUser(Long userId);

    Integer updateUser(UpdateUserRequest updataUserRequest);

    UserResponse selectUser(Long userId);

    User login(Long phoneNumber, String password);
}
