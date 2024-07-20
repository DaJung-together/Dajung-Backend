package com.dajung.user.service;

import java.util.Optional;

import com.dajung.user.domain.entity.User;
import com.dajung.user.domain.vo.LoginUser;
import com.dajung.user.port.LoadUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserQueryService {

    private final LoadUserPort loadUserPort;

    public void create(Long id) {
        User user = loadUserPort.getById(id);
    }

    public Optional<LoginUser> findLoginUser(String loginId) {
        return loadUserPort.findLoginUser(loginId);
    }
}
