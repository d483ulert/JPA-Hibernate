package com.my.toyprj.board.service;
import com.my.toyprj.board.dto.BoardDTO;
import com.my.toyprj.board.entity.Board;
import com.my.toyprj.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService  {

    private final BoardRepository boardRepository;

    @Transactional
    public List<Board> list(){
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC,"num"));
    }

    @Transactional
    public void write(BoardDTO boardDTO,Board board)  {
        board = Board.builder()
                .content(boardDTO.getContent())
                .hart(boardDTO.getHart())
                .writer(boardDTO.getWriter())
                .title(boardDTO.getTitle())
                .writeTime(boardDTO.getWriteTime())
                .view(boardDTO.getView())
                .build();
        boardRepository.save(board);
    }

    @Transactional(readOnly = true)
    public Board read(int num) {
        return boardRepository.getById(num);
    }

    @Transactional
    public void delete(int num){
        boardRepository.deleteById(num);
    }

    @Transactional
    public Board modifyView(int num) {
        return boardRepository.getById(num);
    }

    @Transactional
    public void modify(BoardDTO boardDTO, Board board) {
       board = boardRepository.getById(boardDTO.getNum());
       board.update(boardDTO.getTitle(),boardDTO.getContent());

    }

    @Transactional
    public void viewPlus(int num) {
        Board board = boardRepository.getById(num);
        board.updateHit(board.getView());
    }

    @Transactional
    public void plusHart(int num) {
        Board board = boardRepository.getById(num);
        board.updateHart(board.getHart());
    }

}