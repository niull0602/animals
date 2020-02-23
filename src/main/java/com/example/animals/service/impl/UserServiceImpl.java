package com.example.animals.service.impl;

import com.example.animals.dao.UserDao;
import com.example.animals.pojo.User;
import com.example.animals.request.AddUserRequest;
import com.example.animals.request.UpdateUserRequest;
import com.example.animals.response.UserResponse;
import com.example.animals.service.UserService;
import com.example.animals.utils.CodeCache;
import com.example.animals.utils.JwtUtil;
import com.example.animals.utils.MD5Util;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by lemon on 2020-02-20 13:52.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public boolean saveCode(Long username, String code) {
        CodeCache codeCache = CodeCache.getInstance();
        return codeCache.save(username, MD5Util.getMD5(code));
    }

    @Override
    public boolean sendCode(Long username, String code) {
        System.out.println(username+"|"+code);
        return true;
    }

    @Override
    public String getCode(Long username) {
        CodeCache instance = CodeCache.getInstance();
        String code = instance.getCode(username);
        return code;
    }

    @Override
    public void saveToken(Long userId) throws Exception {
        JwtUtil.createToken(userId);
    }

    @Override
    public Long getUserId(String token) {
        Long userId =null;
        try {
            userId = JwtUtil.getUserId(token);
        } catch (Exception e){
            e.printStackTrace();
        }
        return userId;
    }

    @Override
    public User login(Long phoneNumber, String password) {
        User user = userDao.login(phoneNumber,password);
        if(user!=null){
            return user;
        }else{
            return null;
        }
    }

    @Override
    public Integer addUser(AddUserRequest addUserRequest, Short mark) {
        User user = new User();
        BeanUtils.copyProperties(addUserRequest,user);
        if(mark==0){
            user.setMark((short) 0);
        }
        user.setCreateTime(new Date());
        return userDao.addUser(user);
    }

    @Override
    public Integer deleteUser(Long userId) {
        return userDao.deleteUser(userId);
    }

    @Override
    public Integer updateUser(UpdateUserRequest updataUserRequest) {
        User user = new User();
        BeanUtils.copyProperties(updataUserRequest,user);
        return userDao.updateUser(user);
    }

    @Override
    public UserResponse selectUser(Long userId) {
        UserResponse userResponse = new UserResponse();
        User user =  userDao.selectUser(userId);
        BeanUtils.copyProperties(user,userResponse);
        return userResponse;
    }

    Integer exits(Long phoneNumber){
        return userDao.selectUserByPhoneNumber(phoneNumber);
    }
}
