package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @projectName: demo
 * @package: com.example.demo.controller
 * @className: FileUploadController
 * @author: Vangogh
 * @description: 文件上传控制器
 * @date: 2024/7/10 14:04
 * @version: 1.0
 */


@RestController
public class FileUploadController {
    @PostMapping("/upload")
    public String up(String nickname, MultipartFile photo, HttpServletRequest request)throws IOException {
        System.out.println(nickname);
        //获取文件名
        System.out.println(photo.getOriginalFilename());
        //文件类型
        System.out.println(photo.getContentType());
        //System.out.println(System.getProperty("user.dir"));

        //获取文件路径
        String path = request.getServletContext().getRealPath("/upload");
        System.out.println(path);
        //保存文件
        saveFile(photo,path);
        return "上传成功";
    }

    private void saveFile(MultipartFile photo, String path) throws IOException {
        //不存在就创建路径
        File dir = new File(path);
        if(!dir.exists()){
            dir.mkdirs();
        }
        //保存文件
        File file = new File(path,photo.getOriginalFilename());
        photo.transferTo(file);
    }
}
