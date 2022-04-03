package com.my.toyprj.board.entity;
import com.my.toyprj.base.TimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Board extends TimeEntity {

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

    @Builder
    public Board(Integer num, String writer, String content, int view, String title, LocalDateTime writeTime,int hart) {
        this.num = num;
        this.writer = writer;
        this.content = content;
        this.view = view;
        this.title= title;
        this.writeTime=writeTime;
        this.hart=hart;
    }


}