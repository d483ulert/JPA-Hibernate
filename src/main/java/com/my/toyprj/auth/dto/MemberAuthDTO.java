package com.my.toyprj.auth.dto;
import com.my.toyprj.auth.entity.MemberAuth;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberAuthDTO {

    private Long userAuthNo;

    private Long userNo;

    private String auth;

    private LocalDateTime regDate;

    private LocalDateTime upDate;

    @Builder
    public MemberAuthDTO(Long userNo, String auth){
        this.userNo =userNo;
        this.auth=auth;
    }

    public MemberAuth toEntity(int userNo, String auth){
        return new MemberAuth(userNo,auth);
    }
}
