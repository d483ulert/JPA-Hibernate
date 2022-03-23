package com.my.toyprj.board.controller;
import com.my.toyprj.board.dto.BoardDTO;
import com.my.toyprj.board.entity.BoardEntity;
import com.my.toyprj.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BoardController {
    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/board/list")
    public String BoardList(){
        return "/board/boardList";
    }


    @GetMapping("/board/read")
    public String BoardRead(){

        return "/board/boardRead";
    }


    @GetMapping("/board/write")
    public String BoardWrite(){

        return "/board/boardWrite";
    }

    @PostMapping("/board/create")
    public void CreateBoard(BoardDTO boardDTO){
        System.out.println("boardDTO"+boardDTO.toString());

        BoardEntity entity = boardDTO.toEntity();

        BoardEntity saved = boardRepository.save(entity);
    }

}
