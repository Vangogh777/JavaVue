package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.web.bind.annotation.*;

/**
 * @projectName: demo
 * @package: com.example.demo.controller
 * @className: UserController
 * @author: Vangogh
 * @description: 实现RestFul API
 * @date: 2024/7/18 20:45
 * @version: 1.0
 */

@RestController
public class UserController {

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") Integer id){
        return "根据ID获取用户 id:"+id;
    }

    @PostMapping("/user")
    public String save(User user)
    {
        return "添加用户";
    }

    @PutMapping("/user")
    public String update(User user)
    {
        return "更新用户";
    }

    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable("id") int id)
    {
        return "删除用户 id:"+id;
    }

}
