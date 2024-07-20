package com.dajung.user.domain.vo;

import com.dajung.account.domain.entity.Account;

import lombok.Getter;

@Getter
public class LoginUser {
	private Long id;
	private String status;
	private Account account;

	public LoginUser(final Long id, final String status, final Account account) {
		this.id = id;
		this.status = status;
		this.account = account;
	}
}
