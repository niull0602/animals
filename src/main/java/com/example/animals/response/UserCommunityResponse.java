package com.example.animals.response;

import com.example.animals.bo.ImgBo;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by NiuLilu on 2020-02-29 15:54.
 */
@Data
public class UserCommunityResponse {
    private Long id;

    private String content;

    private Date createTime;

    /**
     * 发互动的多个图片
     */

    private List<ImgBo> imgUrlsBoList;
}
