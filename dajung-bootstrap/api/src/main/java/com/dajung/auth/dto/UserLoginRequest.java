package com.dajung.auth.dto;

public record UserLoginRequest(
	String loginId,
	String password
) {

}
