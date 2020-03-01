package com.example.animals.service;

import com.example.animals.request.AddCommunityRequest;
import com.example.animals.response.CommunityResponse;
import com.example.animals.response.CommunitySearchResponse;
import com.example.animals.response.UserCommunityResponseList;

/**
 * @program: animals
 * @description:
 * @author: Jaysrr
 **/
public interface CommunityService {

    public CommunitySearchResponse findAll(Integer page, Integer size);


    CommunityResponse findById(Long id);

    //查找一个community
//    Community findCommunityByAdoptId(Long adoptId);

    //查找communityList
    CommunitySearchResponse findCommunitiesByAdoptId(Long adoptId);


    CommunitySearchResponse findCommunitiesContentLike(Integer page, Integer size, String content);

    CommunitySearchResponse searchCommunities(Integer page, Integer size, String content);

    Integer deleteCommunityById(Long id);

    Integer insertCommunity(AddCommunityRequest addCommunityRequest);

    UserCommunityResponseList findCommunitiesByUserId(Integer page, Integer size, Long userId);
}


