package com.my.toyprj.auth.repository;

import com.my.toyprj.auth.entity.MemberAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberAuthRepository extends JpaRepository<MemberAuth,Long> {
}
