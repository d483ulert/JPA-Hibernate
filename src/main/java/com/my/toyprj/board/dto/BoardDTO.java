package com.my.toyprj.board.dto;

import com.my.toyprj.board.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
@ToString
@Setter
public class BoardDTO {

    private int num;
    private String writer;
    private String content;
    private int view;
    private String title;
    private LocalDateTime writeTime;
    public BoardEntity toEntity(){
        return new BoardEntity(null,writer,content,view,title);
    }

    @Builder
    public BoardDTO(int num, String writer, String content,int view,String title,LocalDateTime writerTime){
        this.num= num;
        this.writer=writer;
        this.content=content;
        this.view=view;
        this.title=title;
        this.writeTime=writerTime;
    }

}
