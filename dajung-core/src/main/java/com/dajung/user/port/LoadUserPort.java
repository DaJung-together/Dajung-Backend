package com.dajung.user.port;

import com.dajung.user.domain.entity.User;

public interface LoadUserPort {

    User getById(Long id);

}
