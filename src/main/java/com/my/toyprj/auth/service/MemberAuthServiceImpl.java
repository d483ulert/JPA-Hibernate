package com.my.toyprj.auth.service;

import com.my.toyprj.auth.dto.MemberAuthDTO;
import com.my.toyprj.auth.entity.MemberAuth;
import com.my.toyprj.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service("memberAuthServiceImpl")
public class MemberAuthServiceImpl implements MemberAuthService {

    private final MemberRepository memberRepository;
    @Override
    public void AuthAdd(MemberAuthDTO memberAuthDTO) {
        MemberAuth memberAuth = new MemberAuth();

        memberAuth.builder()
                .auth("A")
                .build();
    }
}
