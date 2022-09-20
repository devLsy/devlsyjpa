package com.devlsy.devlsyjpa.repository;

import com.devlsy.devlsyjpa.domain.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    // 멤버 단건 조회
    public MemberEntity findByMemberId(Long memberId);

    // 멤버 단건 삭제
    public void deleteByMemberId(Long memberId);
}
