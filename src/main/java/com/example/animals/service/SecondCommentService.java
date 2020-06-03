package com.example.animals.service;

import com.example.animals.pojo.SecondComments;
import com.example.animals.request.AddOneCommentRequest;
import com.example.animals.request.AddSecondCommentRequest;
import com.example.animals.response.OneCommentResponse;
import com.example.animals.response.OneCommentSearchResponse;
import com.example.animals.response.SecondCommentResponse;
import com.example.animals.response.SecondCommentSearchResponse;

import java.util.List;

/**
 * @program: animals
 * @description:
 * @author: Jaysrr
 **/
public interface SecondCommentService {

    public SecondCommentSearchResponse findAll(Integer page, Integer size);

    public SecondCommentResponse findById(Integer page, Integer size, Long id);

    Integer deleteById(Long id);

    Integer insertSecondComment(AddSecondCommentRequest addSecondCommentRequest);

    List<SecondCommentResponse> findSecondCommentByOneCommentId(Integer page, Integer size, Long oneCommentId);

}


