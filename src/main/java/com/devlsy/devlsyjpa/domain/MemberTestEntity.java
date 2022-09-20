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
@Table(name = "member_test1")
public class MemberTestEntity {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long memberId;

    private String name;

    @CreationTimestamp
    @Column(name = "reg_date", updatable = false)
    private LocalDateTime regdate;

    @Column(name = "update_date")
    @UpdateTimestamp
    private LocalDateTime updateDate;

    @Builder
    public MemberTestEntity(Long memberId, String name, LocalDateTime regdate, LocalDateTime updateDate) {
        this.memberId = memberId;
        this.name = name;
        this.regdate = regdate;
        this.updateDate = updateDate;
    }
}
