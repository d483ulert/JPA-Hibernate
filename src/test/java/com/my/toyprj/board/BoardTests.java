package com.my.toyprj.board;
import com.my.toyprj.board.entity.Board;
import com.my.toyprj.board.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class BoardTests {

    @Autowired
    BoardRepository boardRepository;

    @Test()
    void save(){
        Board board = Board.builder()
                .title("1번 게시글 제목")
                .content("1번 게시글 내용")
                .writer("홍길동")
                .writeTime(LocalDateTime.now())
                .view(1)
                .hart(0)
                .build();

        boardRepository.save(board);
    }

    @Test
    void findAll(){
        long boardCount =boardRepository.count();

        List<Board> board = (List<Board>) boardRepository.findAll();
    }
    @Test
    void delete(){
        Board entity = boardRepository.getById(26);
        boardRepository.delete(entity);
    }

    @Test
    @Transactional
    void update(){
        Board board = boardRepository.getById(28);
        board.update("제목수정","본문수정");
    }
}
