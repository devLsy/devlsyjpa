package com.devlsy.devlsyjpa.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@Builder
public class MemberDTO {

    private Long memberId;
    private String name;
    private String email;

    private LocalDateTime regDate;
    private LocalDateTime updateDate;

    public static MemberDTO fromEntity(MemberEntity member) {
        return MemberDTO.builder()
                .memberId(member.getMemberId())
                .name(member.getName())
                .email(member.getEmail())
                .regDate(member.getRegDate())
                .updateDate(member.getUpdateDate())
                .build();
    }
}
