package com.example.animals.mapper;

import com.example.animals.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends CommonMapper<User> {
}