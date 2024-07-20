package com.dajung.account.domain.port;

import com.dajung.account.domain.entity.Account;

public interface SaveAccountPort {

	void save(Account account);
}
