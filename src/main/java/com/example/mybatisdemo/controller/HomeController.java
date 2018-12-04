package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.base.BaseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/guest")
    public BaseDTO login(){
        return BaseDTO.successBaseDTO("欢迎进入，您的身份是游客");
    }
    @GetMapping("/guest/getMessage")
    public BaseDTO submitLogin() {
        return BaseDTO.successBaseDTO("您拥有获得该接口的信息的权限！");
    }
    @GetMapping("/user/getMessage")
    public BaseDTO getMessage() {
        return BaseDTO.successBaseDTO("您拥有用户权限，可以获得该接口的信息！");
    }
    @GetMapping("/admin/getMessage")
    public BaseDTO getMessage2() {
        return BaseDTO.successBaseDTO("您拥有管理员权限，可以获得该接口的信息！");
    }

}
