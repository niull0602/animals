package com.example.animals.response;

import lombok.Data;

import java.util.List;

/**
 * @program: animals
 * @description:
 * @author: Jaysrr
 **/
@Data
public class OneCommentSearchResponse {
    private List<OneCommentResponse> list;
    private Long total;

}
