package com.example.animals.response;

import com.example.animals.pojo.User;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * @program: animals
 * @description:
 * @author: Jaysrr
 **/
@Data
public class SecondCommentResponse {
    private Long id;

    private String content;

    private Date createTime;


    /** 
    * @Description: 关于user的信息  包含发二级评论的人 以及回复当前二级评论的人
    */
    private Long fromUserId;

    private String fromUserNickName;

    private Long toUserId;

    private String toUserNickName;


}
