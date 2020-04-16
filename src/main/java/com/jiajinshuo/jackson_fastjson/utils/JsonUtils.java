package com.jiajinshuo.jackson_fastjson.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

/**
 * @author jiajinshuo
 * @create 2020-04-15 22:47
 */
public class JsonUtils {

    public static String getJson(Object object){

        return getJson(object,"yyyy:MM:dd HH:mm:ss");

    }

    public static String getJson(Object object,String dateformat){

        ObjectMapper objectMapper = new ObjectMapper();
        //不使用时间戳的方式
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
        objectMapper.setDateFormat(sdf);

        String s = null;
        try {
            s = objectMapper.writeValueAsString(object);
            return s;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
