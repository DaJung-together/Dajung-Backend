package com.dajung.config.auth.filter;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.dajung.auth.dto.UserLoginRequest;
import com.dajung.common.exception.AuthenticationErrorCode;
import com.dajung.common.exception.NotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final AuthenticationManager authenticationManager;

	public UserAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws
		AuthenticationException {

		UserLoginRequest userLoginRequest;

		try {
			ServletInputStream inputStream = request.getInputStream();
			userLoginRequest = new ObjectMapper().readValue(inputStream, UserLoginRequest.class);
		} catch (IOException exception) {
			throw new NotFoundException(AuthenticationErrorCode.LOGIN_REQUEST_EXCEPTION, exception.getMessage());
		}

		final UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
			userLoginRequest.loginId(), userLoginRequest.password());

		return authenticationManager.authenticate(authRequest);
	}
}
