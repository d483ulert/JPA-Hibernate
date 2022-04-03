package com.my.toyprj.board.repository;
import com.my.toyprj.board.entity.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board,Integer> {
}
