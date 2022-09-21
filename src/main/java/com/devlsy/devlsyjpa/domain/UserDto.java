package com.devlsy.devlsyjpa.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserDto {
    private Long userId;
    private String name;

    private LocalDateTime regDate;
    private LocalDateTime updateDate;

    /**
     *  convert from entity
     */

    public static UserDto convertFromEntity(UserEntity userEntity) {
        return UserDto.builder()
                .userId(userEntity.getUserId())
                .name(userEntity.getName())
                .regDate(userEntity.getRegDate())
                .updateDate(userEntity.getUpdateDate())
                .build();
    }
}
