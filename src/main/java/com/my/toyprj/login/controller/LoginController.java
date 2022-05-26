package com.my.toyprj.login.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/index")
    public String login(){
        return "login/index";
    }

    @GetMapping("/disallow")
    public String disallow(){
        return "login/disallow";
    }

    @GetMapping("/user")
    public String UserLogin(){
        return "common/main";
    }

    @GetMapping("/admin")
    public String AdminLogin(){
        return "common/main";
    }

    @GetMapping("/fail")
    public @ResponseBody  String LoginFail(){
        return "로그인 실패하였습니다";
    }

    @GetMapping("/logout")
    public @ResponseBody String logout(){
        return "로그아웃 되었습니다";
    }

}
