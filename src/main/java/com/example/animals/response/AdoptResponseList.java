package com.example.animals.response;

import lombok.Data;

import java.util.List;

/**
 * Created by lemon on 2020-02-26 22:52.
 */
@Data
public class AdoptResponseList {
    private List<AdoptResponse> list;
    private Integer total;
}
