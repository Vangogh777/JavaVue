package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @projectName: demo
 * @package: com.example.demo.controller
 * @className: ParamController
 * @author: Vangogh
 * @description: TODO
 * @date: 2024/5/10 16:13
 * @version: 1.0
 */

@RestController
public class ParamController {

    @RequestMapping(value =  "/getTest1",method = RequestMethod.GET)
    public String getTest1(){
        return "get请求";
    }

    //http://localhost:8080/getTest2?nickname=张三&phone=123456
    @RequestMapping(value =  "/getTest2",method = RequestMethod.GET)
    public String getTest2(String nickname,String phone){
        System.out.println(phone);
        System.out.println(nickname);
        return "get请求 "+nickname + " " + phone;
    }


    //参数映射
    //http://localhost:8080/getTest3?nickname=张三
    @RequestMapping(value =  "/getTest3",method = RequestMethod.GET)
    public String getTest3(@RequestParam(value = "nickname",required = false) String name){
        System.out.println("nickname:"+name);
        return "get请求";
    }

    //post

    @RequestMapping(value = "/postTest1",method = RequestMethod.POST)
    public String postTest1(){
        return "post请求1";
    }

    @RequestMapping(value = "/postTest2",method = RequestMethod.POST)
    public String postTest2(String nickname,String phone){
        System.out.println(phone);
        System.out.println(nickname);
        return "post请求2 "+nickname + " " + phone;

    }

    @RequestMapping(value = "/postTest3",method = RequestMethod.POST)
    public String postTest3(User user){
        System.out.println(user);
        return "post请求3";
    }

    @RequestMapping(value = "/postTest4",method = RequestMethod.POST)
    public String postTest4(@RequestBody User user){
        System.out.println(user);
        return "post请求4";
    }

    //通配符请求
    @RequestMapping(value = "/test/**",method = RequestMethod.GET)
    public String test(){
        return "通配符请求";
    }
}
