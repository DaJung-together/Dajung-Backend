package com.dajung.account.domain.port;

import java.util.Optional;

import com.dajung.account.domain.entity.Account;
import com.dajung.account.domain.entity.LoginType;

public interface LoadAccountPort {

	Optional<Account> findAccount(Long userId, LoginType loginType);
}
