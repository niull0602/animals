package com.example.animals.service.impl;

import com.example.animals.service.UserService;
import com.example.animals.utils.CodeCache;
import com.example.animals.utils.JwtUtil;
import com.example.animals.utils.MD5Util;
import org.springframework.stereotype.Service;

/**
 * Created by lemon on 2020-02-20 13:52.
 */
@Service
public class UserServiceImpl implements UserService {
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
    public void saveToken(Long phoneNumber) throws Exception {
        String token = JwtUtil.createToken(phoneNumber);
    }

    @Override
    public Long getIdByPhoneNumber(Long phoneNumber) {
        return null;
    }

    @Override
    public Long getPhoneNumber(String token) {
        return JwtUtil.getPhoneNumber(token);
    }
}
