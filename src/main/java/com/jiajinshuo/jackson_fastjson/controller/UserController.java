package com.jiajinshuo.jackson_fastjson.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.jiajinshuo.jackson_fastjson.model.User;
import com.jiajinshuo.jackson_fastjson.utils.JsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jiajinshuo
 * @create 2020-04-15 21:46
 */
@RestController
public class UserController {

    @RequestMapping("/test1")
    public String json1() throws JsonProcessingException {

        User user = new User("jiajinshuo", "男", 23);
        //使用jackson

        return JsonUtils.getJson(user);

    }
    @RequestMapping("/test2")
    public String json2() throws JsonProcessingException {

        List<User> list = new ArrayList<>();
        User user = new User("jiajinshuo", "男", 23);
        User user1 = new User("tom", "男", 23);
        User user2 = new User("jerry", "男", 23);
        User user3 = new User("marry", "男", 23);

        list.add(user);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        //使用fastjson
        String s1 = JSON.toJSONString(user);
        System.out.println("java对象转json字符串"+s1);
        //接收前端的东西
        User user4 = JSON.parseObject(s1, User.class);
        System.out.println("json字符串转java对象"+user4);

        JSONObject o = (JSONObject)JSON.toJSON(user);
        System.out.println("Java对象转json对象"+o);

        User user5 = JSON.toJavaObject(o, User.class);
        System.out.println("json对象转为java对象"+user5);


        return "hello";
    }
    @RequestMapping("/date")
    public String json3() throws JsonProcessingException {
        //把日期转化为字符串

        return JsonUtils.getJson(new Date());

    }
}
