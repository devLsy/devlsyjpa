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
import java.util.stream.Collectors;

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
//        List<MemberDTO> memberDTOList = new ArrayList<>();    // foreach 사용할 경우 사용
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        
        // 아래 둘 중 아무 방법 사용
//        for (MemberEntity memberEntity : memberEntityList) {
//            MemberDTO.fromEntity(memberEntity);
//        }
        
        List<MemberDTO> result = memberEntityList.stream()
                .map(m -> MemberDTO.fromEntity(m))
                .collect(Collectors.toList());
        return result;
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
