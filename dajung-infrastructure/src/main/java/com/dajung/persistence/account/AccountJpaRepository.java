package com.dajung.persistence.account;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dajung.account.domain.entity.Account;
import com.dajung.account.domain.entity.LoginType;

public interface AccountJpaRepository extends JpaRepository<Account, Long> {

	Optional<Account> findByUserIdAndLoginType(Long userId, LoginType loginType);
}
