package com.my.toyprj.board.dto;

import com.my.toyprj.board.entity.Board;
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
    private int hart;
    private LocalDateTime writeTime;

    public Board toEntity(){
        return new Board(null,writer,content,view,title, writeTime, hart);
    }

    @Builder
    public BoardDTO(int num, String writer, String content,int view,String title,int hart, LocalDateTime writerTime){
        this.num= num;
        this.writer=writer;
        this.content=content;
        this.view=view;
        this.title=title;
        this.hart=hart;
        this.writeTime=writerTime;
    }

}
