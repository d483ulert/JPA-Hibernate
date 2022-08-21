package com.my.toyprj.auth.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name="MemberAuth")
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
    private LocalDateTime updateTime;

    @Builder
    public MemberAuth(Long userNo, String auth){
        this.userNo =userNo;
        this.auth=auth;
    }


}
