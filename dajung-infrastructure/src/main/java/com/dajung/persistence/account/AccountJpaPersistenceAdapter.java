package com.dajung.persistence.account;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dajung.account.domain.entity.Account;
import com.dajung.account.domain.entity.LoginType;
import com.dajung.account.domain.port.LoadAccountPort;
import com.dajung.account.domain.port.SaveAccountPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AccountJpaPersistenceAdapter implements SaveAccountPort, LoadAccountPort {

	private final AccountJpaRepository accountJpaRepository;

	@Transactional(readOnly = true)
	@Override
	public Optional<Account> findAccount(Long userId, LoginType loginType) {
		return accountJpaRepository.findByUserIdAndLoginType(userId, loginType);
	}

	@Transactional
	@Override
	public void save(Account account) {
		accountJpaRepository.save(account);
	}
}
