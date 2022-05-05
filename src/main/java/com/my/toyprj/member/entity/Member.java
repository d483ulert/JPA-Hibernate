package com.my.toyprj.member.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    @Column
    String userNo;

    @Column
    String userId;

    @Column
    String passwd;

    @Column
    String userName;

    @Column
    String email;

    @Column
    String phoneNum;

    @Column
    int hartNo;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime recentlyLogin;

    @Builder
    public Member( String userId, String passwd, String userName, String email, String phoneNum, int hartNo){
        this.userId = userId;
        this.passwd = passwd;
        this.userName = userName;
        this.email = email;
        this.phoneNum = phoneNum;
        this.hartNo = hartNo;
    }

}
