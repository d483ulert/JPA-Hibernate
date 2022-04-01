package com.my.toyprj.board.dto;

import com.my.toyprj.board.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@NoArgsConstructor
@ToString
@Setter
public class BoardDTO {

    private int num;
    private String writer;
    private String content;
    private LocalDateTime writeTime;
    private int view;
    private String title;

    public BoardEntity toEntity(){
        return new BoardEntity(null,writer,content,writeTime,view,title);
    }

    @Builder
    public BoardDTO(int num, String writer, String content,LocalDateTime writeTime,int view,String title){
        this.num= num;
        this.writer=writer;
        this.content=content;
        this.writeTime=writeTime;
        this.view=view;
        this.title=title;
    }


}
