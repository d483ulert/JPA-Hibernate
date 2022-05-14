package com.my.toyprj.common.config;

import com.my.toyprj.member.entity.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUser extends User {

    private static final long serialVersionUID=1L;

    private Member member;

    public CustomUser(String userId, String passwd, Collection<? extends GrantedAuthority> authorities){
        super(userId,passwd,authorities);
    }

    public CustomUser(Member member){
        super(member.getUserId(),member.getPasswd(), member.getAuthList().stream().map(auth->new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
        this.member=member;
    }

    public Member getMember(){
        return member;
    }
}
