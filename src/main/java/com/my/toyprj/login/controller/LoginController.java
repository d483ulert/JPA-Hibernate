package com.my.toyprj.login.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
