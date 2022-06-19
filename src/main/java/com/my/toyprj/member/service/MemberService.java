package com.my.toyprj.member.service;

import com.my.toyprj.member.dto.MemberDTO;
import com.my.toyprj.member.entity.Member;
import com.my.toyprj.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void add(MemberDTO memberDTO) {
        String rawPassword = memberDTO.getPasswd();
        String encPassword = passwordEncoder.encode(rawPassword);

        Member member= new Member();
        member = member.builder()
                .userId(memberDTO.getUserId())
                .userName(memberDTO.getUserName())
                .email(memberDTO.getEmail())
                .passwd(encPassword)
                .phoneNum(memberDTO.getPhoneNum())
                .userRole("User")
                .recentlyLogin(memberDTO.getRecentlyLogin())
                .build();
        memberRepository.save(member);
    }
}
