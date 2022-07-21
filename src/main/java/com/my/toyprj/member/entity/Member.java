package com.my.toyprj.member.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.my.toyprj.auth.entity.MemberAuth;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@Table(name="Member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY	)
    @Column
    private Long userNo;

    @Column
    private String userId;

    @Column
    private String passwd;

    @Column
    private String userName;

    @Column
    private String email;

    @Column
    private String phoneNum;

    @Column
    private int hartNo;

    @Column
    private String userRole;

    @Column
    private int isActivated;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime recentlyLogin;

    @Builder
    public Member( String userId, String passwd, String userName, String email, String phoneNum,String userRole,int isActivated, int hartNo,LocalDateTime recentlyLogin){
        this.userId = userId;
        this.passwd = passwd;
        this.userName = userName;
        this.email = email;
        this.phoneNum = phoneNum;
        this.hartNo = hartNo;
        this.userRole=userRole;
        this.isActivated=isActivated;
        this.recentlyLogin =recentlyLogin;
    }

    @ManyToMany
    @JoinTable(name="MemberAuth",joinColumns = {@JoinColumn(name="userNo", referencedColumnName = "userNo")},
    inverseJoinColumns = {@JoinColumn(name="userNo", referencedColumnName = "userNo")})
    private Set <MemberAuth> authorities;

}