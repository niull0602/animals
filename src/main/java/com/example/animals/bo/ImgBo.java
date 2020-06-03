package com.example.animals.bo;

import lombok.Data;
import lombok.ToString;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Vector;

/**
 * Created by lemon on 2020-02-18 23:58.
 */
@Data
@ToString
public class ImgBo {
    private String imgUUID;
    private String imgUrl;
}

