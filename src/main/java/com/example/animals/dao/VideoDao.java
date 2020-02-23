package com.example.animals.dao;

import com.example.animals.mapper.VideoMapper;
import com.example.animals.pojo.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/2/21
 * @Description:小冯同学写点注释吧！
 */
@Repository
public class VideoDao {
    @Autowired
    VideoMapper videoMapper;

    public Integer addVideo(Video video){
        return videoMapper.insert(video);
    }

    public Integer deleteVideo(Integer videoId){
        return videoMapper.deleteByPrimaryKey(videoId);
    }

    public List<Video> selectVideo(Integer userId){
        Example example = new Example(Video.class);
        example.createCriteria().andEqualTo("userId",userId);
        return videoMapper.selectByExample(example);
    }

    public List<Video> selectAllVideo(){
        return videoMapper.selectAll();
    }
}
