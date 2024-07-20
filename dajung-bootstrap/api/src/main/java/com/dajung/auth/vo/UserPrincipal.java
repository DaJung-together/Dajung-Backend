package com.dajung.auth.vo;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dajung.user.domain.vo.LoginUser;

public class UserPrincipal implements UserDetails {

	private final LoginUser userInfo;
	private final Map<String, Object> attributes;

	public UserPrincipal(final LoginUser userInfo) {
		this.userInfo = userInfo;
		this.attributes = new HashMap<>();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(userInfo.getAccount().getRole().name()));
	}

	@Override
	public String getPassword() {
		return userInfo.getAccount().getPassword();
	}

	@Override
	public String getUsername() {
		return userInfo.getAccount().getEmail();
	}
}
