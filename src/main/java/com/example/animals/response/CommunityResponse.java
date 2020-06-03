package com.example.animals.response;

import com.example.animals.bo.ImgBo;
import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(value = "网名")
    private String nickName;
    @ApiModelProperty(value = "真实姓名")
    private String name;
    @ApiModelProperty(value = "头像")
    private String imgUrl;

    private Long phoneNumber;

    private String content;
    @ApiModelProperty(value = "发表时间")
    private String createTime;

    /**
     * 发互动的多个图片
     */

    private List<ImgBo> imgUrlsBoList;

    private List<OneCommentResponse> commentResponseList;

}
