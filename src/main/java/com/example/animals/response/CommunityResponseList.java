package com.example.animals.response;

import lombok.Data;

import java.util.List;

/**
 * Created by lemon on 2020-02-25 16:21.
 */
@Data
public class CommunityResponseList {
    private List<CommunityResponse> list;

    private Long total;
}
