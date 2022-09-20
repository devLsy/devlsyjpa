package com.devlsy.devlsyjpa.repository;

import com.devlsy.devlsyjpa.domain.MemberTestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberTestRepository extends JpaRepository<MemberTestEntity, Long> {

    // select member by member_id
    public MemberTestEntity findByMemberId(Long memberId);

    // delete member by member_id
    public void deleteByMemberId(Long memerId);

}
