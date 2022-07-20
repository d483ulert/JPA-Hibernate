package com.my.toyprj.security.config;

import com.my.toyprj.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component("UserDetailsService")
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    public CustomUserDetailService(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(final String userId)  {
        return memberRepository.findOneWithAuthoritiesByUsername(userId)
                .map(member-> createMember(userId,member))
                .orElseThrow(() -> new UsernameNotFoundException(userId + "null"));
    }

    private org.springframework.security.core.userdetails.User createMember(String username, Object member) {
        if (!member.isActivated()) {
            throw new RuntimeException(username + " -> 활성화되어 있지 않습니다.");
        }
        List<GrantedAuthority> grantedAuthorities = member.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthorityName()))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(member.getUsername(),
                member.getPassword(),
                grantedAuthorities);
    }
}
