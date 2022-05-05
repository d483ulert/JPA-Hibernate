package com.my.toyprj.member.dto;
import com.my.toyprj.member.entity.Member;
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


    public Member toEntity(){
        return new Member(userId,passwd,userName,email,phoneNum,hartNo);
    }

    @Builder
    public MemberDTO(String userId, String passwd, String userName, String email, String phoneNum, int hartNo){
        this.userId = userId;
        this. passwd = passwd;
        this.userName = userName;
        this.email = email;
        this.phoneNum = phoneNum;
        this.hartNo =hartNo;
    }
}
