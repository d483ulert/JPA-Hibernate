package com.my.toyprj.board.controller;
import com.my.toyprj.board.dto.BoardDTO;
import com.my.toyprj.board.entity.Board;
import com.my.toyprj.board.service.BoardService;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@SuppressWarnings("unchecked")
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public ResponseEntity<Board> BoardList() {
        return new ResponseEntity<Board>((Board) boardService.list(),HttpStatus.OK);
    }

    @GetMapping("/read")
    public String BoardRead(int num, Model model)  {
        model.addAttribute("data",boardService.read(num));
        boardService.viewPlus(num);
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

    @DeleteMapping("/delete/{num}")
    public String  DeleteBoard(@PathVariable int num)  {
        boardService.delete(num);
        return "redirect:/board/list";
    }

    @GetMapping("/modifyView")
    public String ModifyView(int num, Model model, Board board){
        System.out.println("num:"+num);
        model.addAttribute("data",boardService.modifyView(num));

        return "board/boardModify";
    }

    @PutMapping("/modify")
    public String ModifyBoard(BoardDTO boardDTO,Board board){
        boardService.modify(boardDTO,board);
        return "redirect:/board/list";
    }

    @PutMapping("/plusHart")
    public @ResponseBody HashMap<String,Object> HartPlus(@RequestParam Map<String,Object> param){
        boardService.plusHart(Integer.parseInt(param.get("num").toString()));
        HashMap hmap = new HashMap<String,Object>();
        Board board = boardService.read(Integer.parseInt(param.get("num").toString()));
        hmap.put("hart",board.getHart());
        return hmap;
    }

 /*   @PostMapping("/zzz")
    public ResponseEntity<BoardDTO> glgl(@RequestHeader(value="Authorization") @NotNull String Authorization) {
        return new ResponseEntity<BoardDTO>(boardService(Integer.parseInt(param.get("num").toString())),HttpStatus.OK);
    }*/
}
