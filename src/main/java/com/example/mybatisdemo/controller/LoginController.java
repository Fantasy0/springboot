package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.base.BaseDTO;
import com.example.mybatisdemo.dao.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {
    @Resource
    private UserMapper userMapper;

    @RequestMapping(value = "/notLogin", method = RequestMethod.GET)
    public BaseDTO notLogin() {
        return BaseDTO.successBaseDTO("您尚未登陆！");
    }

    @RequestMapping(value = "/notRole", method = RequestMethod.GET)
    public BaseDTO notRole() {
        return BaseDTO.successBaseDTO("您没有权限！");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public BaseDTO logout() {
        Subject subject = SecurityUtils.getSubject();
        //注销
        subject.logout();
        return BaseDTO.successBaseDTO("成功注销！");
    }

    /**
     * 登陆
     *
     * @param username 用户名
     * @param password 密码
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public BaseDTO login(String username, String password) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        subject.login(token);
        //根据权限，指定返回数据
        String role = userMapper.getRole(username);
        if ("user".equals(role)) {
            return BaseDTO.successBaseDTO("欢迎登陆");
        }
        if ("admin".equals(role)) {
            return BaseDTO.successBaseDTO("欢迎来到管理员页面");
        }
        return BaseDTO.failBaseDTO("权限错误！");
    }
}
