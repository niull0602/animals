package com.example.animals.response;

import com.example.animals.pojo.Type;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Created by lemon on 2020-02-19 12:49.
 */
@Data
@ToString
public class GoodTypeResponse {
    List<Type> list;
    Long total;
}
