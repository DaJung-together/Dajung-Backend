package com.dajung.controller.user.dto;

import com.dajung.user.dto.command.UserCreateCommand;
import jakarta.validation.constraints.Pattern;

public record UserCreateRequest( //-> 입력값 검증
        @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
        message = "이메일 형식에 맞지 않는 입력값입니다.")
        String email,
        String password,
        String name,
        String nickname,
        String contactNumber,
        String address
) {
    //7개
    public static UserCreateCommand toCommand() {
        return new UserCreateCommand();
    }

}
