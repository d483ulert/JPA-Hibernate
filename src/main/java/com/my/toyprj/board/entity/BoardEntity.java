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
    @Override
    public String toString() {
        return "BoardEntity{" +
                "num=" + num +
                ", writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                ", writeTime=" + writeTime +
                ", view=" + view +
                '}';
    }

    public BoardEntity(Integer num, String writer, String content, Date writeTime, int view) {
        this.num = num;
        this.writer = writer;
        this.content = content;
        this.writeTime = writeTime;
        this.view = view;
    }


}
