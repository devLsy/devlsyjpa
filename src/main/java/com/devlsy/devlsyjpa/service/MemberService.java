package com.devlsy.devlsyjpa.service;

import com.devlsy.devlsyjpa.domain.MemberDTO;
import com.devlsy.devlsyjpa.domain.MemberEntity;
import com.devlsy.devlsyjpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    /**
     * 멤버 리스트 조회
     * @return
     */
    @Transactional(readOnly = true)
    public List<MemberDTO> findAllList() {
        List<MemberDTO> memberDTOList = new ArrayList<>();
        List<MemberEntity> memberEntityList = memberRepository.findAll();

        for (MemberEntity member: memberEntityList) {
            memberDTOList.add(MemberDTO.fromEntity(member));
        }
        return memberDTOList;
    }

    /**
     * 멤버 단건 조회
     * @param
     * @return
     */
    @Transactional(readOnly = true)
    public MemberDTO findMember(Long memberId) {
        MemberEntity findMember = memberRepository.findByMemberId(memberId);
        return MemberDTO.fromEntity(findMember);
    }

    /**
     * 멤버 단건 삭제
     * @param
     * @return
     */
    @Transactional
    public void deleteMember(Long memberId) {
        memberRepository.deleteByMemberId(memberId);
    }

    /**
     * 멤버 등록
     * @param
     * @return
     */

    @Transactional
    public Long createMember(MemberDTO memberDTO) {
        MemberEntity member = MemberEntity.builder()
                .memberId(memberDTO.getMemberId())
                .name(memberDTO.getName())
                .email(memberDTO.getEmail())
                .build();

        MemberEntity save = memberRepository.save(member);
        return save.getMemberId();
    }

}
