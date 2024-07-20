package com.dajung.facade;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dajung.account.dto.command.UserSignUpCommand;
import com.dajung.account.service.AccountSignUpService;
import com.dajung.user.service.UserSignUpService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignUpFacadeService {

	private final UserSignUpService userSignUpService;
	private final AccountSignUpService accountSignUpService;

	@Transactional
	public void signUp(final UserSignUpCommand userSignUpCommand) {
		Long userId = userSignUpService.join(userSignUpCommand);
		accountSignUpService.signUp(userSignUpCommand, userId);
	}
}
