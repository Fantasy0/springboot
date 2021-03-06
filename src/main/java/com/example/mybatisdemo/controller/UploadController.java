package com.example.mybatisdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传测试
 * @author lcp
 * @date 2018.12.3
 */
@Controller
public class UploadController {
    private static Logger logger = LoggerFactory.getLogger(UploadController.class);
    @GetMapping("/show")
    public String showUpload(){
        return "upload";
    }
    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file){
        if(file.isEmpty()){
            return "上传失败，请选择文件";
        }
        String fileName = file.getOriginalFilename();
        String filePath = "D:/";
        File dest =new File(filePath+fileName);
        try {
            file.transferTo(dest);
            logger.info("上传成功！");
            return "上传成功！";
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败！";
        }
    }
}
