package com.my.toyprj.board.controller;
import com.my.toyprj.board.dto.BoardDTO;
import com.my.toyprj.board.entity.Board;
import com.my.toyprj.board.repository.BoardRepository;
import com.my.toyprj.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;


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
    public String BoardRead(int num, Model model) throws Exception {
        model.addAttribute("data",boardService.read(num));
        return "board/boardRead";
    }

    @GetMapping("/write")
    public String BoardWrite(BoardDTO boardDTO ){
        return "board/boardWrite";
    }

    @PostMapping("/write")
    public String CreateBoard(BoardDTO boardDTO,Board board) throws Exception{
        boardDTO.setWriteTime(LocalDateTime.now());
        boardService.write(boardDTO,board);
        return "redirect:/board/list";
    }

    @DeleteMapping("/delete")
    public void DeleteBoard(BoardDTO boardDTO, Board board){
        System.out.println(board+"\n***\n"+boardDTO);


    }

}
