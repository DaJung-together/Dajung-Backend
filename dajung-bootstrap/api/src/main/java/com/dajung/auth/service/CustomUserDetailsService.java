package com.dajung.auth.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dajung.auth.vo.UserPrincipal;
import com.dajung.common.exception.GlobalErrorCode;
import com.dajung.common.exception.NotFoundException;
import com.dajung.user.domain.vo.LoginUser;
import com.dajung.user.service.UserQueryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final UserQueryService userQueryService;

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginUser loginUser = userQueryService.findLoginUser(username)
			.orElseThrow(() -> new NotFoundException(GlobalErrorCode.NOT_FOUND_ENTITY_EXCEPTION));

		return new UserPrincipal(loginUser);
	}
}
