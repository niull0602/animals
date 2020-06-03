package com.example.animals.controller;

import com.example.animals.common.SzpJsonResult;
import com.example.animals.pojo.User;
import com.example.animals.request.AddUserRequest;
import com.example.animals.request.UpdateUserRequest;
import com.example.animals.response.LoginResponse;
import com.example.animals.response.SelectUserResponse;
import com.example.animals.response.UserResponse;
import com.example.animals.service.UserService;
import io.swagger.annotations.ApiOperation;
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
        LoginResponse login = userService.login(phoneNumber, password);
        if (login.getToken()!=null)
        return SzpJsonResult.ok(login);
        else
            return new SzpJsonResult(401,"账号或密码错误",null);
    }
    @PostMapping(value = "add/user")
    public SzpJsonResult<Integer> addUser(@RequestBody AddUserRequest addUserRequest){
        return SzpJsonResult.ok(userService.addUser(addUserRequest));
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
    @ApiOperation("判断用户是否存在")
    @GetMapping(value = "exits/user")
    public SzpJsonResult<Integer> exitsUser(@RequestParam(value = "phoneNumber")Long phoneNumber){
        return SzpJsonResult.ok(userService.exits(phoneNumber));
    }
    @ApiOperation("关键字查询")
    @GetMapping(value = "find/user/keyword")
    public SzpJsonResult<SelectUserResponse> findUserByKeywords(@RequestParam(value = "keyword",required = false)String keyword,
                                                                @RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber,
                                                                @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){
        return SzpJsonResult.ok(userService.findUserByKeywords(keyword,pageNumber,pageSize));
    }

    @GetMapping(value = "find/all/user")
    public SzpJsonResult<SelectUserResponse> findAllUser(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber,
                                                         @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){
        return SzpJsonResult.ok(userService.findAllUser(pageNumber,pageSize));
    }

}
