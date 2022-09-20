package com.devlsy.devlsyjpa.controller;

import com.devlsy.devlsyjpa.domain.MemberDTO;
import com.devlsy.devlsyjpa.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    // 멤버 등록
    @PostMapping("/")
    public Long createMember(@RequestBody MemberDTO memberDTO) {
        return memberService.createMember(memberDTO);
    }

    // 멤버 조회
    @GetMapping("/{memberId}")
    public MemberDTO findOneMember(@PathVariable Long memberId) {
        return memberService.findMember(memberId);
    }

    // 멤버 목록 조회
    @GetMapping("/")
    public List<MemberDTO> findAllMember() {
        return memberService.findAllList();
    }

    // 멤버 삭제
    @DeleteMapping("/{memberId}")
    public void deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
    }

}
