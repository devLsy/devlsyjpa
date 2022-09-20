package com.devlsy.devlsyjpa.service;

import com.devlsy.devlsyjpa.domain.MemberTestDTO;
import com.devlsy.devlsyjpa.domain.MemberTestEntity;
import com.devlsy.devlsyjpa.repository.MemberTestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberTestService {

    private final MemberTestRepository memberTestRepository;

    // findOne member by member_id
    @Transactional(readOnly = true)
    public MemberTestDTO findOneMember(Long memberId) {
        MemberTestEntity findMember = memberTestRepository.findByMemberId(memberId);
        return MemberTestDTO.convertFromEntity(findMember);
    }

    // delete member by member_id
    @Transactional
    public void deleteMember(Long memberId) {
        memberTestRepository.deleteByMemberId(memberId);
    }

    // findList member
    @Transactional(readOnly = true)
    public List<MemberTestDTO> findAllMember() {
        List<MemberTestDTO> memberTestDTOList = new ArrayList<>();
        List<MemberTestEntity> findAllMemberList = memberTestRepository.findAll();

        for (MemberTestEntity memberTest: findAllMemberList) {
            memberTestDTOList.add(MemberTestDTO.convertFromEntity(memberTest));
        }
        return memberTestDTOList;
    }

    // insert member
    @Transactional
    public Long createMember(MemberTestDTO memberTestDTO) {
        MemberTestEntity memberTest = MemberTestEntity.builder()
                            .memberId(memberTestDTO.getMemberId())
                            .name(memberTestDTO.getName())
                            .build();
        MemberTestEntity saveMember = memberTestRepository.save(memberTest);
        return saveMember.getMemberId();
    }
}
