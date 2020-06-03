package com.example.animals.request;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @program: animals
 * @description:
 * @author: Jaysrr
 **/
@Data
public class AddOneCommentRequest {

    private Long communityId;

    private String content;

    private Long userId;

}

