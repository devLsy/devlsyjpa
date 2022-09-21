package com.devlsy.devlsyjpa.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "user")
@NoArgsConstructor
public class UserEntity {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long userId;

    private String name;

    @CreationTimestamp
    @Column(name = "reg_date", updatable = false)
    private LocalDateTime regDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Builder
    public UserEntity(Long userId, String name, LocalDateTime regDate, LocalDateTime updateDate) {
        this.userId = userId;
        this.name = name;
        this.regDate = regDate;
        this.updateDate = updateDate;
    }

    /**
     *  convert from dto
     */
    public static UserEntity convertFromDto(UserDto userDto) {
        return UserEntity.builder()
                .userId(userDto.getUserId())
                .name(userDto.getName())
                .build();
    }
}
