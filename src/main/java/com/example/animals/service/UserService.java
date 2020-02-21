package com.example.animals.service;

/**
 * Created by lemon on 2020-02-20 13:52.
 */
public interface UserService {
    boolean saveCode(Long phoneNumber, String code);

    boolean sendCode(Long phoneNumber, String code);

    String getCode(Long phoneNumber);

    void saveToken(Long phoneNumber) throws Exception;

    Long getIdByPhoneNumber(Long phoneNumber);

    Long getPhoneNumber(String token);
}
