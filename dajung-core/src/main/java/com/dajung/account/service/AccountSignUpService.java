package com.dajung.account.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dajung.account.domain.entity.Account;
import com.dajung.account.domain.entity.LoginType;
import com.dajung.account.domain.port.LoadAccountPort;
import com.dajung.account.domain.port.SaveAccountPort;
import com.dajung.account.dto.command.UserSignUpCommand;
import com.dajung.common.exception.ExistsException;
import com.dajung.common.exception.GlobalErrorCode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountSignUpService {

	private final SaveAccountPort saveAccountPort;
	private final LoadAccountPort loadAccountPort;

	@Transactional
	public void signUp(final UserSignUpCommand userSignUpCommand, final Long userId) {
		// 계정 존재 여부 확인
		validAccountExists(userId, userSignUpCommand.loginType());

		// 계정 생성
		Account account = Account.builder()
			.email(userSignUpCommand.email())
			.password(userSignUpCommand.password())
			.userId(userId)
			.role(userSignUpCommand.role())
			.build();

		saveAccountPort.save(account);

		// 이메일 인증 삭제
	}

	private void validAccountExists(final Long userId, final LoginType loginType) {
		loadAccountPort.findAccount(userId, loginType)
			.ifPresent(account -> {throw new ExistsException(GlobalErrorCode.EXISTS_ENTITY_EXCEPTION);});
	}
}
