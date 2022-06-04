package com.my.toyprj.member;
import com.my.toyprj.member.entity.Member;
import com.my.toyprj.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class memberTests {
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void findUserId(){

       Member member = memberRepository.findByUserId("제니");
        System.out.println(member.getUserId());
    }

}
