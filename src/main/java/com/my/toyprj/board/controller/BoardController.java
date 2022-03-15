package com.my.toyprj.board.controller;
import com.my.toyprj.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/list")
    public String BoardList(Model model){
        System.out.println("ss");
        return "/board/boardList";
    }


    @GetMapping("/read")
    public String BoardRead(){

        return "/board/boardRead";
    }


    @GetMapping("/write")
    public String BoardWrite(){

        return "/board/boardWrite";
    }

}
