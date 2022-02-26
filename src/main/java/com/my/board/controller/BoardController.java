package com.my.board.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @RequestMapping("/list")
    public String BoardList(Model model){

        return "boardList";
    }


    @RequestMapping("/read")
    public String BoardRead(){

        return "boardRead";
    }


    @RequestMapping("write")
    public String BoardWrite(){

        return "boardWrite";
    }

}
