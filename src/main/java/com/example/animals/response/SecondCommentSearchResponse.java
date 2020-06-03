package com.example.animals.response;

import lombok.Data;

import java.util.List;

/**
 * @program: animals
 * @description:
 * @author: Jaysrr
 **/
@Data
public class SecondCommentSearchResponse {
    private List<SecondCommentResponse> list;
    private Long total;
}
