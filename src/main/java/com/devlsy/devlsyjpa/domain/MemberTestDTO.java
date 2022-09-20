package com.devlsy.devlsyjpa.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MemberTestDTO {

    private Long memberId;
    private String name;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;

    public static MemberTestDTO convertFromEntity(MemberTestEntity memberTest) {
        return MemberTestDTO.builder()
                .memberId(memberTest.getMemberId())
                .name(memberTest.getName())
                .regDate(memberTest.getRegdate())
                .updateDate(memberTest.getUpdateDate())
                .build();
    }
}
