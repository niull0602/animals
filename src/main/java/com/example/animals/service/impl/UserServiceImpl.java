package com.example.animals.service.impl;

import com.example.animals.constant.AnimalsConstant;
import com.example.animals.dao.UserDao;
import com.example.animals.pojo.User;
import com.example.animals.request.AddUserRequest;
import com.example.animals.request.UpdateUserRequest;
import com.example.animals.response.LoginResponse;
import com.example.animals.response.SelectUserResponse;
import com.example.animals.response.UserResponse;
import com.example.animals.service.UserService;
import com.example.animals.utils.CodeCache;
import com.example.animals.utils.JsonUtils;
import com.example.animals.utils.JwtUtil;
import com.example.animals.utils.MD5Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by lemon on 2020-02-20 13:52.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean saveCode(Long username, String code) {
        CodeCache codeCache = CodeCache.getInstance();
        return codeCache.save(username, MD5Util.getMD5(code));
    }

    @Override
    public boolean sendCode(Long username, String code) {
        System.out.println(username + "|" + code);
        return true;
    }

    @Override
    public String getCode(Long username) {
        CodeCache instance = CodeCache.getInstance();
        String code = instance.getCode(username);
        return code;
    }

    @Override
    public String saveToken(Long userId) throws Exception {
        return JwtUtil.createToken(userId);
    }

    @Override
    public Long getUserId(String token) {
        Long userId = null;
        try {
            userId = JwtUtil.getUserId(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userId;
    }

    @Override
    public LoginResponse login(Long phoneNumber, String password) throws Exception {
        LoginResponse loginResponse = new LoginResponse();
        User user = userDao.login(phoneNumber, password);
        if (user != null) {
            loginResponse.setUser(user);
            String uuid = UUID.randomUUID().toString();
            String token = uuid + "," + user.getId() + "," + user.getNickName() + "," + user.getPhoneNumber();
            //将token留在redis中
            stringRedisTemplate.opsForValue().set(token, JsonUtils.objectToJson(user));
            stringRedisTemplate.expire(token, 10, TimeUnit.DAYS);
            loginResponse.setToken(token);
        }
        return loginResponse;
    }

    @Override
    public Integer addUser(AddUserRequest addUserRequest) {
        User user = new User();
        BeanUtils.copyProperties(addUserRequest, user);
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
        BeanUtils.copyProperties(updataUserRequest, user);
        return userDao.updateUser(user);
    }

    @Override
    public UserResponse selectUser(Long userId) {
        UserResponse userResponse = new UserResponse();
        User user = userDao.selectUser(userId);
        BeanUtils.copyProperties(user, userResponse);
        return userResponse;
    }

    @Override
    public Integer exits(Long phoneNumber) {
        return userDao.selectUserByPhoneNumber(phoneNumber);
    }

    @Override
    public SelectUserResponse findUserByKeywords(String keyword, Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        List<User> userList  = null;
        if (!StringUtils.isEmpty(keyword)) {
            userList = userDao.findUserByKeyWord(keyword);
        }else {
            userList = userDao.findAll();
        }
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        SelectUserResponse selectUserResponse = new SelectUserResponse();
        selectUserResponse.setList(pageInfo.getList());
        selectUserResponse.setTotal(pageInfo.getTotal());
        return selectUserResponse;
    }

    @Override
    public SelectUserResponse findAllUser(Integer pageNumber, Integer pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        List<User> userList = userDao.findAll();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        SelectUserResponse selectUserResponse = new SelectUserResponse();
        selectUserResponse.setList(pageInfo.getList());
        selectUserResponse.setTotal(pageInfo.getTotal());
        return selectUserResponse;
    }
}
