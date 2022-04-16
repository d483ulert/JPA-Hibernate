package com.my.toyprj.board.service;
import com.my.toyprj.board.dto.BoardDTO;
import com.my.toyprj.board.entity.Board;

import java.util.List;

public interface BoardService {

    public List<Board> list();

    public void write(BoardDTO boardDTO,Board board);

    public Board read(int num);

    public void delete(int num);

    public Board modify(int num);
}
