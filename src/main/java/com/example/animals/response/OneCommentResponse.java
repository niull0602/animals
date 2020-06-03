package com.example.animals.response;

import com.example.animals.pojo.SecondComments;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @program: animals
 * @description:
 * @author: Jaysrr
 **/
@Data
public class OneCommentResponse {
    private Long id;

    private Long communityId;

    private String content;
    @ApiModelProperty(value = "发表时间")
    private String createTime;


    private Long userId;

    private String nickName;

    private String headimgUrl;


}
