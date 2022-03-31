package com.my.toyprj.board.entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
public class BoardEntity {

    @Column
    @Id
    @GeneratedValue
    private int num;
    @Column
    private String writer;
    @Column
    private String content;
    @Column
    private Date writeTime;
    @Column
    private int view;
    @Column
    private String title;


    @Builder
    public BoardEntity(Integer num, String writer, String content, Date writeTime, int view, String title) {
        this.num = num;
        this.writer = writer;
        this.content = content;
        this.writeTime = writeTime;
        this.view = view;
        this.title= title;
    }


}