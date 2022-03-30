package com.my.toyprj.board.dto;

import com.my.toyprj.board.entity.BoardEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BoardDTO {

    private int num;
    private String writer;
    private String content;
    private Date writeTime;
    private int view;
    private String title;

    public BoardEntity toEntity(){
        return new BoardEntity(null,writer,content,writeTime,view,title);
    }



}
