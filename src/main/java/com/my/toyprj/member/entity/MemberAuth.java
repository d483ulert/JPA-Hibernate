package com.my.toyprj.member.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(of="userNo")
public class MemberAuth {

    @Column
    @GeneratedValue
    @Id
    private Long userAuthNo;

    @Column
    private Long userNo;

    @Column
    private String auth;

    @Column
    private LocalDateTime regDate;

    @Column
    private LocalDateTime upDate;

    @Builder
    public MemberAuth(Long userNo, String auth){
        this.userNo =userNo;
        this.auth=auth;
    }

}
