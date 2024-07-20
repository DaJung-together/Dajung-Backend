package com.dajung.config.auth.filter;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;

import com.dajung.common.exception.BusinessException;
import com.dajung.response.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExceptionFilter extends OncePerRequestFilter {

	private final ObjectMapper objectmapper;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
		FilterChain filterChain) throws ServletException, IOException {
		try {
			filterChain.doFilter(request, response);
		} catch (BusinessException exception) {
			sendErrorResponse(response, HttpStatus.UNAUTHORIZED, exception);
		}
	}

	private void sendErrorResponse(HttpServletResponse response, HttpStatus status, BusinessException exception) throws IOException {
		response.setStatus(status.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(objectmapper.writeValueAsString(ErrorResponse.of(exception.getErrorCode())));
	}
}
