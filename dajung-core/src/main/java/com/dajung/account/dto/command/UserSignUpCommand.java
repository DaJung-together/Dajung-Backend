package com.dajung.account.dto.command;

import com.dajung.account.domain.entity.LoginType;
import com.dajung.account.domain.entity.Role;

import lombok.Builder;

@Builder
public record UserSignUpCommand(
	String email,
	String password,
	String name,
	String nickname,
	String phoneNumber,
	Role role,
	LoginType loginType
) {

}
