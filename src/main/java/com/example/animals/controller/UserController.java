package com.example.animals.controller;

import com.example.animals.common.SzpJsonResult;
import com.example.animals.pojo.User;
import com.example.animals.request.AddUserRequest;
import com.example.animals.request.UpdateUserRequest;
import com.example.animals.response.LoginResponse;
import com.example.animals.response.UserResponse;
import com.example.animals.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:Fengxutong
 * @Date:2020/2/19
 * @Description:小冯同学写点注释吧！
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "login")
    public SzpJsonResult<LoginResponse> login(@RequestParam Long phoneNumber, @RequestParam String password) throws Exception {
        return SzpJsonResult.ok(userService.login(phoneNumber,password));
    }
    @PostMapping(value = "add/user")
    public SzpJsonResult<Integer> addUser(@RequestBody AddUserRequest addUserRequest,@RequestParam Short mark){
        return SzpJsonResult.ok(userService.addUser(addUserRequest,mark));
    }
    @DeleteMapping(value = "delete/user/{userId}")
    public SzpJsonResult<Integer> deleteUser(@PathVariable(value = "userId") Long userId){
        return SzpJsonResult.ok(userService.deleteUser(userId));
    }
    @PutMapping(value = "update/user")
    public SzpJsonResult<Integer> updateUser(@RequestBody UpdateUserRequest updateUserRequest){
        return SzpJsonResult.ok(userService.updateUser(updateUserRequest));
    }

    @GetMapping(value = "select/user/by/id")
    public SzpJsonResult<UserResponse> selectUser(@RequestParam Long userId){
        return SzpJsonResult.ok(userService.selectUser(userId));
    }

    @GetMapping(value = "exits/user")
    public SzpJsonResult<Integer> exitsUser(@RequestParam(value = "phoneNumber")Long phoneNumber){
        return SzpJsonResult.ok(userService.exits(phoneNumber));
    }
}
