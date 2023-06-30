package com.my.toyprj.board.dto;
import lombok.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@Data
public class BoardDTO {

    private int num;
    private String writer;
    private String content;
    private int view;
    private String title;
    private int hart;
    private LocalDateTime writeTime;

}
