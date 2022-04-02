package com.my.toyprj.board.entity;
import com.my.toyprj.base.TimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class BoardEntity extends TimeEntity {

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


    @Builder
    public BoardEntity(Integer num, String writer, String content, int view, String title) {
        this.num = num;
        this.writer = writer;
        this.content = content;
        this.view = view;
        this.title= title;
    }


}