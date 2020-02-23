package com.example.animals.service;

import com.example.animals.pojo.Video;
import com.example.animals.request.AddVideoRequest;
import com.example.animals.request.SelectVideoRequestByUserId;
import com.example.animals.response.VideoResponseList;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/2/21
 * @Description:小冯同学写点注释吧！
 */
public interface VideoService {

    Integer addVideo(AddVideoRequest videoRequest);

    Integer deleteVideo(Integer videoId);

    VideoResponseList selectVideo(SelectVideoRequestByUserId selectVideoRequestByUserId);

    VideoResponseList selectVideo(Integer pageNumber, Integer size);
}
