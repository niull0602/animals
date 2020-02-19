package com.example.animals.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
/**
 * Created by lemon on 2020-02-19 23:16.
 */
public class JsonUtils {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 将对象转换成json字符串。
     */
    public static String objectToJson(Object data) {
        try {
            String string = MAPPER.writeValueAsString(data);
            return string;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 将json结果集转化为对象
     */
    public static <T> T jsonToPoJo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 将json数据转换成pojo对象list
     */
    public  static <T> T jsonToList(String jsonData, TypeReference<T> typeReference) {
        try {
            return MAPPER.readValue(jsonData, typeReference);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        HashMap<String,String> msg=new HashMap<>();
        msg.put("A","B");
        String objectToJson = JsonUtils.objectToJson(msg);
        System.out.println(objectToJson);
        HashMap hashMap = JsonUtils.jsonToPoJo(objectToJson, HashMap.class);
        System.out.println(hashMap);
    }
}