package com.my.toyprj.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.http.HttpRequest;
import java.util.HashMap;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {


    @GetMapping("/join")
    public String Join(){

        return "member/join";
    }

    @PostMapping("/pwdVal")
    public HashMap pwd(@RequestParam String pwd, @RequestParam String pwd2){
        HashMap<String,String> hmap = new HashMap<>();

        return hmap;
    }




}
