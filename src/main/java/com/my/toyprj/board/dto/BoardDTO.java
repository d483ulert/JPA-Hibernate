package com.my.toyprj.board.dto;

import com.my.toyprj.board.entity.BoardEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
public class BoardDTO {

    private int num;
    private String writer;
    private String content;
    private Date writeTime;
    private int view;

    public BoardEntity toEntity() {

        return new BoardEntity(null,writer,content,writeTime,view);
    }

}
