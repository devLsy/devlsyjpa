package com.devlsy.devlsyjpa.controller;

import com.devlsy.devlsyjpa.domain.MemberTestDTO;
import com.devlsy.devlsyjpa.service.MemberTestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/member")
public class MemberTestController {

    private final MemberTestService memberTestService;

    @PostMapping(value = "/")
    public Long createMember(@RequestBody MemberTestDTO memberTestDTO) {
        return memberTestService.createMember(memberTestDTO);
    }

    @DeleteMapping("/{memberId}")
    public void deleteMember(@PathVariable Long memberId) {
        memberTestService.deleteMember(memberId);
    }

    @GetMapping("/{memberId}")
    public MemberTestDTO findOneMember(@PathVariable Long memberId) {
        return memberTestService.findOneMember(memberId);
    }

    @GetMapping("/")
    public List<MemberTestDTO> findAllMember() {
        return memberTestService.findAllMember();
    }

}
