package com.example.animals.response;

import lombok.Data;

import java.util.List;

/**
 * Created by NiuLilu on 2020-02-29 15:56.
 */
@Data
public class UserCommunityResponseList {
    private List<UserCommunityResponse> list;
    private Long total;
}
