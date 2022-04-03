package com.my.toyprj.board.service;

import com.my.toyprj.board.dto.BoardDTO;
import com.my.toyprj.board.entity.Board;
import com.my.toyprj.board.repository.BoardRepository;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("boardServiceImpl")
public class BoardServiceImpl implements BoardService {

    private BoardRepository boardRepository;

    @Override
    @Transactional
    public List<BoardDTO.BoardDTOBuilder> BoardList() {
        List<Board> boardList = (List<Board>) boardRepository.findAll();
        List<BoardDTO.BoardDTOBuilder> boardDTOList = new ArrayList<>();

        for(Board board: boardList){
            BoardDTO.BoardDTOBuilder boardDTO =BoardDTO.builder()
                    .num(board.getNum())
                    .title(board.getTitle())
                    .view(board.getView())
                    .writer(board.getWriter())
                    .writeTime(board.getWriteTime())
                    .hart((board.getHart()));

            boardDTOList.add(boardDTO);
        }

        return boardDTOList;
    }
}
