package com.example.mybatisdemo.controller;

import com.example.mybatisdemo.base.BaseDTO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        if(SecurityUtils.getSubject().isAuthenticated()){
            return "redirect:/index";
        }else {
            return "login";
        }
    }
    @PostMapping("/login")
    @ResponseBody
    public BaseDTO  login(String username, String password, Model model){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        subject.login(token);
        try {
            //shiro帮我们匹配密码什么的，我们只需要把东西传给它，它会根据我们在UserRealm里认证方法设置的来验证
            subject.login(token);
            return BaseDTO.successBaseDTO();
        }catch (LockedAccountException lae) {
            token.clear();
            return new BaseDTO(500, "用户已经被锁定不能登录，请与管理员联系！", null);
        }catch (AuthenticationException e) {
            token.clear();
            return new BaseDTO(500, "用户或密码不正确", null);
        }
    }
    /**
     * 退出
     * @return
     */
    @RequestMapping("/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "login";
    }

}
