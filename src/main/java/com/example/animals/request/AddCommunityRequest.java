package com.example.animals.request;

import lombok.Data;

import java.util.List;

/**
 * @program: animals
 * @description:
 * @author: Jaysrr
 **/
@Data
public class AddCommunityRequest {

    private Long adoptId;

    private String content;

    /**
     * 发互动的多个图片
     */
    private List<String> imgUrlsList;

}
