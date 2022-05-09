package com.my.toyprj.member.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.my.toyprj.auth.entity.MemberAuth;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name="Member")
public class Member {

    @Id
    @GeneratedValue
    @Column
    int userNo;

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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="userNo")
    private List <MemberAuth> authList;



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
