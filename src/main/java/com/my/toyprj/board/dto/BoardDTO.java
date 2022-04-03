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
    private LocalDateTime writeTime;
    private int hart;
    public Board toEntity(){
        return new Board(null,writer,content,view,title,writeTime,hart);
    }

    @Builder
    public BoardDTO(int num, String writer, String content,int view,String title,LocalDateTime writeTime,int hart){
        this.num= num;
        this.writer=writer;
        this.content=content;
        this.view=view;
        this.title=title;
        this.writeTime=writeTime;
        this.hart=hart;
    }

}
