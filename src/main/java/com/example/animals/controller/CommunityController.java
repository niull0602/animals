package com.example.animals.controller;

import com.example.animals.common.SzpJsonResult;
import com.example.animals.request.AddCommunityRequest;
import com.example.animals.response.CommunityResponse;
import com.example.animals.response.CommunitySearchResponse;
import com.example.animals.response.UserCommunityResponseList;
import com.example.animals.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: animals
 * @description:
 * @author: Jaysrr
 **/
@RestController
@RequestMapping("/community")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @GetMapping("/find/all")
    public SzpJsonResult<CommunitySearchResponse> findAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                          @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return SzpJsonResult.ok(communityService.findAll(page, size));

    }

    @GetMapping("/find/{id}")
    public SzpJsonResult<CommunityResponse> findById(@PathVariable("id") Long id) {
        return SzpJsonResult.ok(communityService.findById(id));
    }


    @GetMapping("/find/communities/{adoptId}")
    public SzpJsonResult<CommunitySearchResponse> findCommunitiesByAdoptId(@PathVariable("adoptId") Long adoptId) {
        return SzpJsonResult.ok(communityService.findCommunitiesByAdoptId(adoptId));
    }


    @GetMapping("/find/community")
    public SzpJsonResult<CommunitySearchResponse> findCommunitiesContentLike(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
            , @RequestParam(value = "content", defaultValue = "") String content) {

        return SzpJsonResult.ok(communityService.findCommunitiesContentLike(page, size, content));
    }

    @GetMapping("/search")
    public SzpJsonResult<CommunitySearchResponse> searchCommunities(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                    @RequestParam(value = "size", defaultValue = "10") Integer size,
                                                                    String content) {
        return SzpJsonResult.ok(communityService.searchCommunities(page, size, content));
    }

    @GetMapping("/find/community/userId")
    public SzpJsonResult<UserCommunityResponseList> findCommunitiesByUserId(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                            @RequestParam(value = "size", defaultValue = "10") Integer size,
                                                                            @RequestParam(value = "userId") Long userId) {
        return SzpJsonResult.ok(communityService.findCommunitiesByUserId(page, size,userId));
    }


    @DeleteMapping("/delete/{id}")
    public SzpJsonResult<Integer> detete(@PathVariable("id") Long id) {
        return SzpJsonResult.ok(communityService.deleteCommunityById(id));
    }

    @PostMapping("/insert")
    public SzpJsonResult<Integer> insertCommunity(@RequestBody AddCommunityRequest addCommunityRequest) {
        return SzpJsonResult.ok(communityService.insertCommunity(addCommunityRequest));
    }


}
