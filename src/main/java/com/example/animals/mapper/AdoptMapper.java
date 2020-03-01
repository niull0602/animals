package com.example.animals.mapper;

import com.example.animals.pojo.Adopt;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdoptMapper extends CommonMapper<Adopt> {
}