package com.example.animals.utils;

import java.text.SimpleDateFormat;

import java.util.Date;

/**
 * Created by lemon on 2020-02-20 20:30.
 */
public class OrderCodeUtil {
    private static long orderNum = 0l;
    private static String date ;
    /**
     * 生成订单编号
     * @return
     */
    public static synchronized String getOrderNo() {
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        if(date==null||!date.equals(str)){
            date = str;
            orderNum  = 0l;
        }
        orderNum ++;
        long orderNo = Long.parseLong((date)) * 100000;
        orderNo += orderNum;;
        return orderNo+"";
    }

}
