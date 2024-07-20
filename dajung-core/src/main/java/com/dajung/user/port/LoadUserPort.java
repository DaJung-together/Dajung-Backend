package com.dajung.user.port;

import java.util.Optional;

import com.dajung.user.domain.entity.User;
import com.dajung.user.domain.vo.LoginUser;

public interface LoadUserPort {

    User getById(Long id);

    Optional<LoginUser> findLoginUser(String loginId);

    Optional<User> findByContactNumber(String contactNumber);
}
