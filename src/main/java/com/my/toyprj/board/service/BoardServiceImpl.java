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
@Service("boardServiceImpl")
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    @Transactional
    public List<Board> list() throws Exception {
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC,"num"));
    }

    @Override
    @Transactional
    public void write(BoardDTO boardDTO,Board board) throws Exception {
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

    @Override
    @Transactional
    public Board read(int num) throws Exception {
        return boardRepository.getById(num);
    }

}