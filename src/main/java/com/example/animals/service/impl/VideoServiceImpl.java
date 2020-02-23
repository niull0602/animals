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
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    VideoDao videoDao;

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
        List<Video> videos = videoDao.selectVideo(selectVideoRequestByUserId.getUserId());
        PageHelper.startPage(selectVideoRequestByUserId.getPageNumber(),selectVideoRequestByUserId.getSize());
        List<VideoResponse> videoResponses = new ArrayList<>();
        for (Video video:videos) {
            VideoResponse videoResponse = new VideoResponse();
            BeanUtils.copyProperties(videos,videoResponse);
            videoResponses.add(videoResponse);
        }
        PageInfo<VideoResponse> pageInfo = new PageInfo<>(videoResponses);
        VideoResponseList videoResponseList = new VideoResponseList();
        videoResponseList.setVideoResponseList(pageInfo.getList());
        videoResponseList.setSize(pageInfo.getTotal());
        return videoResponseList;
    }

    @Override
    public VideoResponseList selectVideo(Integer pageNumber,Integer size) {
        List<Video> videos = videoDao.selectAllVideo();
        PageHelper.startPage(pageNumber,size);
        List<VideoResponse> videoResponses = new ArrayList<>();
        for (Video video:videos) {
            VideoResponse videoResponse = new VideoResponse();
            BeanUtils.copyProperties(videos,videoResponse);
            videoResponses.add(videoResponse);
        }
        PageInfo<VideoResponse> pageInfo = new PageInfo<>(videoResponses);
        VideoResponseList videoResponseList = new VideoResponseList();
        videoResponseList.setVideoResponseList(pageInfo.getList());
        videoResponseList.setSize(pageInfo.getTotal());
        return videoResponseList;
    }
}
