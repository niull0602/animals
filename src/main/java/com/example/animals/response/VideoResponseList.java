package com.example.animals.response;

import lombok.Data;

import java.util.List;

/**
 * @Author:Fengxutong
 * @Date:2020/2/21
 * @Description:小冯同学写点注释吧！
 */
@Data
public class VideoResponseList {
    private List<VideoResponse> videoResponseList;

    private Long size;
}
