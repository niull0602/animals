package com.example.animals.response;

import lombok.Data;

import java.util.List;

/**
 * @program: animals
 * @description:
 * @author: Jaysrr
 * @create: 2020-02-25 16:16
 **/
@Data
public class CommunitySearchResponse{
    private List<CommunityResponse> list;
    private Long total;
}
