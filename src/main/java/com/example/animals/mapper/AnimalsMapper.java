package com.example.animals.mapper;

import com.example.animals.pojo.Animals;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnimalsMapper extends CommonMapper<Animals> {
}