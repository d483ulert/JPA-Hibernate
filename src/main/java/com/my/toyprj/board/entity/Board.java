package com.my.toyprj.board.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Board  {

    @Id
    @GeneratedValue
    @Column
    private int num;

    @Column
    private String writer;

    @Column
    private String content;

    @Column(columnDefinition = "integer default 0 ",nullable = false)
    private int view;

    @Column
    private String title;

    @Column
    private int hart;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime writeTime = LocalDateTime.now();


    @Builder
    public Board( String writer, String content, int view, String title, LocalDateTime writeTime,int hart) {
        this.writer = writer;
        this.content = content;
        this.view = view;
        this.title= title;
        this.writeTime=writeTime;
        this.hart=hart;
    }

    public void update(String title, String content){
        this.title= title;
        this.content=content;
    }

    public void updateHit(int view){
        this.view++;
    }

    public void updateHart(int hart){
        this.hart++;
    }
}