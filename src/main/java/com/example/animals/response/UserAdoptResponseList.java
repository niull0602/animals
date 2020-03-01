package com.example.animals.response;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Created by lemon on 2020-02-25 12:27.
 */
@Data
@ToString
public class UserAdoptResponseList {
    List<UserAdoptResponse> list;
}
