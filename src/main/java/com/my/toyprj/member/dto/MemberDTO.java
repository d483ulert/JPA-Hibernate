package com.my.toyprj.member.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberDTO {

    private String userNo;
    private String userId;
    private String passwd;
    private String userName;
    private String email;
    private String phoneNum;
    private int hartNo;

}
