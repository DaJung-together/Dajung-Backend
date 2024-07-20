package com.dajung.account.domain.entity;

public enum Role {
	ROLE_USER("user"),
	ROLE_ADMIN("admin");

	private final String roleName;

	Role(String roleName) {
		this.roleName = roleName;
	}
}
