package com.my.toyprj.board.controller;
import com.my.toyprj.board.dto.BoardDTO;
import com.my.toyprj.board.entity.BoardEntity;
import com.my.toyprj.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardRepository boardRepository;

    @GetMapping("/list")
    public String BoardList(){
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

    @PostMapping("/create")
    public void CreateBoard(@RequestBody  BoardDTO boardDTO){
        System.out.println("boardDTO"+boardDTO.toString());

        BoardEntity entity = boardDTO.toEntity();

        System.out.println("brdentt"+entity);

        BoardEntity saved = boardRepository.save(entity);
    }

}
