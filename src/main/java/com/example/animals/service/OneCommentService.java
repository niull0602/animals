package com.example.animals.service;

import com.example.animals.pojo.OneComments;
import com.example.animals.request.AddCommunityRequest;
import com.example.animals.request.AddOneCommentRequest;
import com.example.animals.response.CommunityResponse;
import com.example.animals.response.CommunitySearchResponse;
import com.example.animals.response.OneCommentResponse;
import com.example.animals.response.OneCommentSearchResponse;

import java.util.List;

/**
 * @program: animals
 * @description:
 * @author: Jaysrr
 **/
public interface OneCommentService {

    public OneCommentSearchResponse findAll(Integer page, Integer size);

    //    OneCommentResponse findById(Long id);
    public OneCommentResponse findById(Integer page, Integer size, Long id);

    Integer deleteById(Long id);

    Integer insert(AddOneCommentRequest addOneCommentRequest);

    List<OneCommentResponse> findCommentByCommuntyId(Integer page, Integer size,Long communityId);
}


