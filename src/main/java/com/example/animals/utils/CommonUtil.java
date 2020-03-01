package com.example.animals.utils;

import java.util.UUID;

/**
 * Created by lemon on 2020-02-24 23:07.
 */
public class CommonUtil {
    /**
     * 生成指定位数的随机整数
     *
     * @param number
     *            位数
     * @return 随机整数
     */
    public static int random(int number) {
        return (int) ((Math.random() * 9 + 1) * Math.pow(10, number - 1));
    }

    /**
     * 获取UUID
     *
     * @return UUID
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
