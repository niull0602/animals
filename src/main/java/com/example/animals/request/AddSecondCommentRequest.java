package com.example.animals.request;

import lombok.Data;

/**
 * @program: animals
 * @description:
 * @author: Jaysrr
 **/
@Data
public class AddSecondCommentRequest {
    private String content;

    private Long oneCommentId;

    private Long fromUid;

    private Long toUid;

}
