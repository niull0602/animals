package com.example.animals.service.impl;

import com.example.animals.dao.VideoDao;
import com.example.animals.pojo.Video;
import com.example.animals.request.AddVideoRequest;
import com.example.animals.request.SelectVideoRequestByUserId;
import com.example.animals.response.VideoResponse;
import com.example.animals.response.VideoResponseList;
import com.example.animals.service.VideoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/2/21
 * @Description:小冯同学写点注释吧！
 */
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoDao videoDao;

    @Override
    public Integer addVideo(AddVideoRequest videoRequest) {
        Video video = new Video();
        BeanUtils.copyProperties(videoRequest,video);
        video.setCreateTime(new Date());
        return videoDao.addVideo(video);
    }

    @Override
    public Integer deleteVideo(Integer videoId) {
        return videoDao.deleteVideo(videoId);
    }

    @Override
    public VideoResponseList selectVideo(SelectVideoRequestByUserId selectVideoRequestByUserId) {
        PageHelper.startPage(selectVideoRequestByUserId.getPageNumber(),selectVideoRequestByUserId.getSize());
        List<Video> videos = videoDao.selectVideo(selectVideoRequestByUserId.getUserId());
        PageInfo<Video> pageInfo = new PageInfo<>(videos);
        List<VideoResponse> videoResponses = new ArrayList<>();
        for (Video video:pageInfo.getList()) {
            VideoResponse videoResponse = new VideoResponse();
            BeanUtils.copyProperties(video,videoResponse);
            videoResponses.add(videoResponse);
        }
        VideoResponseList videoResponseList = new VideoResponseList();
        videoResponseList.setVideoResponseList(videoResponses);
        videoResponseList.setSize(pageInfo.getTotal());
        return videoResponseList;
    }

    @Override
    public VideoResponseList selectVideo(Integer pageNumber,Integer size) {
        PageHelper.startPage(pageNumber,size);
        List<Video> videos = videoDao.selectAllVideo();
        Collections.shuffle(videos);
        PageInfo<Video> pageInfo = new PageInfo<>(videos);
        List<VideoResponse> videoResponses = new ArrayList<>();
        List<Video> list = pageInfo.getList();
        for (Video video:list) {
            VideoResponse videoResponse = new VideoResponse();
            BeanUtils.copyProperties(video,videoResponse);
            videoResponses.add(videoResponse);
        }
        VideoResponseList videoResponseList = new VideoResponseList();
        videoResponseList.setVideoResponseList(videoResponses);
        videoResponseList.setSize(pageInfo.getTotal());
        return videoResponseList;
    }
}
