package com.my.toyprj.board.controller;
import com.my.toyprj.board.dto.BoardDTO;
import com.my.toyprj.board.entity.Board;
import com.my.toyprj.board.repository.BoardRepository;
import com.my.toyprj.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @GetMapping("/list")
    public String BoardList(Model model) throws Exception{
        model.addAttribute("data",boardService.list());

        return "board/boardList";
    }


    @GetMapping("/read")
    public String BoardRead(BoardDTO boardDTO){

        return "board/boardRead";
    }


    @GetMapping("/write")
    public String BoardWrite(BoardDTO boardDTO ){
        return "board/boardWrite";
    }

    @PostMapping("/write")
    public String CreateBoard(BoardDTO boardDTO){
        System.out.println(boardDTO);
        Board entity = boardDTO.toEntity();
        Board saved = boardRepository.save(entity);

        return "redirect:board/list";
    }

}
