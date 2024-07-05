package com.example.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: demo
 * @package: com.example.demo.controller
 * @className: helloController
 * @author: Vangogh
 * @description: TODO
 * @date: 2024/4/17 16:29
 * @version: 1.0
 */


//标记为控制类  restcontroller 只请求数据可以用 默认返回json格式   controller 请求数据和页面可以用
@RestController
public class helloController {

    //ResquestMapping  请求映射  value 请求路径 method 请求方式 (作用是做url的路径映射） 让url知道去访问哪个方法

    @RequestMapping(value =  "/hello",method = RequestMethod.GET)
    public String hello(String nickname,String phone){
        System.out.println(phone);
        System.out.println(nickname);
        return "你好 "+nickname;
    }

    @RequestMapping(value =  "/getData",method = RequestMethod.GET)
    public String getData(){
        return "你好";
    }

//    public  User getUser(){
//        User user = new User();
//        user.setName("张三");
//        user.setAge(18);
//        return user;
//    }
}
