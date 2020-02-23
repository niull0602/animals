package com.example.animals.controller;

import com.example.animals.common.SzpJsonResult;
import com.example.animals.pojo.User;
import com.example.animals.request.AddUserRequest;
import com.example.animals.request.UpdateUserRequest;
import com.example.animals.response.UserResponse;
import com.example.animals.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:Fengxutong
 * @Date:2020/2/19
 * @Description:小冯同学写点注释吧！
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    public SzpJsonResult<User> login(@RequestParam Long phoneNumber, @RequestParam String password){
        return SzpJsonResult.ok(userService.login(phoneNumber,password));
    }

    public SzpJsonResult<Integer> addUser(@RequestBody AddUserRequest addUserRequest,@RequestParam Short mark){
        return SzpJsonResult.ok(userService.addUser(addUserRequest,mark));
    }

    public SzpJsonResult<Integer> deleteUser(@RequestParam Long userId){
        return SzpJsonResult.ok(userService.deleteUser(userId));
    }

    public SzpJsonResult<Integer> updateUser(@RequestBody UpdateUserRequest updateUserRequest){
        return SzpJsonResult.ok(userService.updateUser(updateUserRequest));
    }

    public SzpJsonResult<UserResponse> selectUser(@RequestParam Long userId){
        return SzpJsonResult.ok(userService.selectUser(userId));
    }
}
