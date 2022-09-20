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
@NoArgsConstructor
@Table(name = "member_test")
public class MemberEntity {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long memberId;
    private String name;
    private String email;

    @CreationTimestamp
    @Column(name = "reg_date", updatable = false)
    private LocalDateTime regDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Builder
    public MemberEntity(Long memberId, String name, String email, LocalDateTime regDate, LocalDateTime updateDate) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.regDate = regDate;
        this.updateDate = updateDate;
    }
}
