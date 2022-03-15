package com.my.toyprj.board.repository;
import com.my.toyprj.board.entity.BoardEntity;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<BoardEntity,Integer> {
}
