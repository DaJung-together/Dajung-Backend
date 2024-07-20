package com.dajung.user.service;

import com.dajung.user.domain.entity.User;
import com.dajung.user.dto.response.UserResponse;
import com.dajung.user.port.LoadUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserQueryService {

    private final LoadUserPort loadUserPort;

    public UserResponse getById(Long id) {
        User user = loadUserPort.getById(id);
        return UserResponse.from(user);
    }

}
