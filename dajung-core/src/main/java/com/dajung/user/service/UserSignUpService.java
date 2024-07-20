package com.dajung.user.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dajung.account.dto.command.UserSignUpCommand;
import com.dajung.common.crypto.Aes256Crypto;
import com.dajung.common.exception.GlobalErrorCode;
import com.dajung.common.exception.NotCryptoException;
import com.dajung.user.domain.entity.User;
import com.dajung.user.port.LoadUserPort;
import com.dajung.user.port.SaveUserPort;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserSignUpService {

	private final LoadUserPort loadUserPort;
	private final SaveUserPort saveUserPort;
	private final Aes256Crypto aes256Crypto;

	@Transactional
	public Long join(UserSignUpCommand userSignUpCommand) {
		// 인증번호 check 기능 및 검증 로직 추가 필요: EamilCertService.confirm();

		// 사용자 찾기
		User userOptional = loadUserPort.findByContactNumber(userSignUpCommand.email())
			.orElseGet(() -> joinUser(userSignUpCommand));

		return userOptional.getId();
	}

	private User joinUser(UserSignUpCommand userSignUpCommand) {
		String encodedPhoneNUmber;
		try {
			encodedPhoneNUmber = aes256Crypto.encrypt(userSignUpCommand.phoneNumber());;
		} catch (Exception exception) {
			throw new NotCryptoException(GlobalErrorCode.CRYPTO_EXCEPTION);
		}

		User user = User.builder()
			.email(userSignUpCommand.email())
			.contactNumber(encodedPhoneNUmber)
			.name(userSignUpCommand.name())
			.nickname(userSignUpCommand.nickname())
			.build();
		saveUserPort.save(user);

		return user;
	}
}

/**
 * AccounSignUpService
 *
 * UserSignUpService
 *
 * 3번 <-> 3번
 * 3번 -> 4번
 * 4번 <-> 4번
 */