package com.dajung.auth.dto;

import com.dajung.account.domain.entity.LoginType;
import com.dajung.account.domain.entity.Role;
import com.dajung.account.dto.command.UserSignUpCommand;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UserSignUpRequest(

	@NotBlank(message = "로그인 아이디를 입력해주세요.")
	String email,

	@NotBlank(message = "비밀번호를 입력해주세요.")
	String password,

	@NotBlank(message = "이름을 입력해주세요.")
	String name,

	@NotBlank(message = "닉네임을 입력해주세요.")
	String nickname,

	@NotBlank
	@Pattern(regexp = "^\\d{11}$", message = "아이디는 휴대폰번호 형식으로 입력해주세요.")
	String contactNumber
) {

	public UserSignUpCommand toUserSignUpCommand(String encodedPassword) {
		return UserSignUpCommand.builder()
			.email(email)
			.password(encodedPassword)
			.name(name)
			.nickname(nickname)
			.phoneNumber(contactNumber)
			.role(Role.ROLE_USER)
			.loginType(LoginType.APP)
			.build();
	}
}
