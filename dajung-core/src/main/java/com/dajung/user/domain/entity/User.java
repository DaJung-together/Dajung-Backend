package com.dajung.user.domain.entity;

import com.dajung.common.entity.BaseEntity;
import com.dajung.user.domain.vo.UserStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = true)
    private String email;

    // TODO: 2024/07/14 연락처 인크립트 & 연락처 or 이메일 인증
    @Column(nullable = false)
    private String contactNumber;
    /**
     * status -> 활성, 휴면, 삭제의 상태
     * 휴면인 경우는 알림이나 상호작용을 받지 않도록
     */
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Builder
    private User(String name,
                String nickname,
                String email,
                String contactNumber,
                UserStatus status) {
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.contactNumber = contactNumber;
        this.status = status;
    }

}
