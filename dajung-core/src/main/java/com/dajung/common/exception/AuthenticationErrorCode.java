package com.dajung.common.exception;

public enum AuthenticationErrorCode implements ErrorCode {

	LOGIN_REQUEST_EXCEPTION("A001", "로그인 요청이 잘못되었습니다.")
		;

	private final String code;
	private final String message;

	AuthenticationErrorCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	@Override
	public String code() {
		return this.code;
	}

	@Override
	public String message() {
		return this.message;
	}

}
