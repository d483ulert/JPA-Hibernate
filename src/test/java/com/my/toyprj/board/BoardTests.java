
package com.my.toyprj.board;

import com.my.toyprj.board.entity.Board;
import com.my.toyprj.board.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class BoardTests {

    @Autowired
    BoardRepository boardRepository;


    @Test
    void save(){
        Board params = Board.builder()
                .title("1번 게시글 제목")
                .content("1번 게시글 내용")
                .writer("홍길동")
                .view(1)
                .hart(0)
                .build();

        boardRepository.save(params);
        Board entity = boardRepository.findById(1).get();
        assertThat(entity.getTitle()).isEqualTo("1번게시글 제목");
        assertThat(entity.getContent()).isEqualTo("1번게시글 내용");
        assertThat(entity.getWriter()).isEqualTo("1번게시글 작성자");
    }

    @Test
    void findAll(){
        long boardCount =boardRepository.count();

        List<Board> board = (List<Board>) boardRepository.findAll();
    }
    @Test
    void delete(){
        Board entity = boardRepository.findById(1).get();
        boardRepository.delete(entity);
    }

}
