package com.example.animals.response;

import com.example.animals.bo.ImgBo;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @program: animals
 * @description:
 * @author: Jaysrr
 * @create: 2020-02-25 16:16
 **/
@Data
public class CommunityResponse {

    private Long id;

    private Long userId;

    private String nickName;

    private String headimgUrl;

    private String content;

    private Date createTime;

    /**
     * 发互动的多个图片
     */

    private List<ImgBo> imgUrlsBoList;

}
