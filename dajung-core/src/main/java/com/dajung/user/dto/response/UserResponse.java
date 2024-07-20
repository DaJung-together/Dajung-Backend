package com.dajung.user.dto.response;

import com.dajung.user.domain.entity.User;
import com.dajung.user.domain.vo.UserStatus;
import lombok.Builder;

@Builder
public record UserResponse(
        Long id,
        String name,
        String nickname,
        String email,
        String contactNumber,
        UserStatus status
) {

    public static UserResponse from(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .contactNumber(user.getContactNumber())
                .status(user.getStatus())
                .build();
    }

}
