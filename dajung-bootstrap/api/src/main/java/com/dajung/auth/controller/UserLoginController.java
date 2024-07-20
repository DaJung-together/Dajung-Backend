package com.dajung.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dajung.auth.dto.UserSignUpRequest;
import com.dajung.facade.SignUpFacadeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserLoginController {

	private final SignUpFacadeService signUpFacadeService;
	private final PasswordEncoder passwordEncoder;

	@PostMapping("sign-up")
	public ResponseEntity<Void> signUp(@RequestBody @Valid UserSignUpRequest userSignUpRequest) {
		signUpFacadeService.signUp(userSignUpRequest.toUserSignUpCommand(passwordEncoder.encode(userSignUpRequest.password())));

		return ResponseEntity.ok().build();
	}
}
