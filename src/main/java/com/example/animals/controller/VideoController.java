package com.example.animals.controller;

import com.example.animals.common.SzpJsonResult;
import com.example.animals.request.AddVideoRequest;
import com.example.animals.request.SelectVideoRequestByUserId;
import com.example.animals.response.VideoResponseList;
import com.example.animals.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:Fengxutong
 * @Date:2020/2/24
 * @Description:小冯同学写点注释吧！
 */
@RestController
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping(value = "add/video")
    public SzpJsonResult<Integer> addVideo(@RequestBody AddVideoRequest videoRequest){
        return SzpJsonResult.ok(videoService.addVideo(videoRequest));
    }

    @DeleteMapping(value = "delete/video/{videoId}")
    public SzpJsonResult<Integer> deleteVideo(@PathVariable(value = "videoId") Integer videoId){
        return SzpJsonResult.ok(videoService.deleteVideo(videoId));
    }

    //根据userId查看该用户发表过的视频
    @PostMapping(value = "select/video/by/userId")
    public SzpJsonResult<VideoResponseList> selectVideo(@RequestBody SelectVideoRequestByUserId selectVideoRequestByUserId){
        return SzpJsonResult.ok(videoService.selectVideo(selectVideoRequestByUserId));
    }

    @GetMapping(value = "select/allVideo")
    public SzpJsonResult<VideoResponseList> selectVideo(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber,
                                                        @RequestParam(value = "size",defaultValue = "10") Integer size){
        return SzpJsonResult.ok(videoService.selectVideo(pageNumber,size));
    }
}
