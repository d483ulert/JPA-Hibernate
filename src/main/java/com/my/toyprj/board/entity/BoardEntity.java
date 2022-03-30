package com.my.toyprj.board.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
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

    public BoardEntity(int num, String writer, String content, Date writeTime, int view, String title) {
        this.num = num;
        this.writer = writer;
        this.content = content;
        this.writeTime = writeTime;
        this.view = view;
        this.title = title;
    }

    public BoardEntity(Integer num, String writer, String content, Date writeTime, int view, String title) {
        this.num = num;
        this.writer = writer;
        this.content = content;
        this.writeTime = writeTime;
        this.view = view;
        this.title= title;
    }


}