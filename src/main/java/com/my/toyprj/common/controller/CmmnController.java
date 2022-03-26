package com.my.toyprj.common.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CmmnController {
    @GetMapping("/main")
    public String Main(){
        return "/common/main";
    }
}
