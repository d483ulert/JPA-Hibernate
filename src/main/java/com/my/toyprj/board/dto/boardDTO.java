package com.my.toyprj.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class boardDTO {

    private int num;
    private String writer;
    private String content;
    private Date writeTime;
    private int view;
}
