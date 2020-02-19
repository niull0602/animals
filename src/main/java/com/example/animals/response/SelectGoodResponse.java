package com.example.animals.response;

import com.example.animals.pojo.Goods;
import lombok.Data;

import java.util.List;

/**
 * Created by lemon on 2020-02-18 22:25.
 */
@Data
public class SelectGoodResponse {
    private List<Goods> goodsList;
    private Long total;
}
