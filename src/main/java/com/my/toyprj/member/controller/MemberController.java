package com.my.toyprj.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {


    @GetMapping("/join")
    public String Join(){

        return "member/join";
    }

    @PostMapping("/pwdVal")
    public @ResponseBody Map pwd(@RequestParam Map<String,String> map){
        if(map.get("passwd").equals(map.get("passwd2"))){
            map.put("alert","true");
        }else{
            map.put("alert","false");
        }
        return map;
    }

    @GetMapping("/popUp")
    public String popUp(){

        return "member/popUp";
    }



}
