package com.my.toyprj.member.controller;

import com.my.toyprj.member.dto.MemberDTO;
import com.my.toyprj.member.service.MemberService;
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

    private final MemberService memberService;

    @GetMapping("/join")
    public String Join(){

        return "member/join";
    }

    @PostMapping("/user")
    public String User(MemberDTO memberDTO){
        memberService.add(memberDTO);

        return "redirect:member/join";
    }


    @PostMapping("/pwdValidation")
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
