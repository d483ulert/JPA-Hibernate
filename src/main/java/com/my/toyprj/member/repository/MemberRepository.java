package com.my.toyprj.member.repository;
import com.my.toyprj.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
    public Member findByUserId(String userId);
}
