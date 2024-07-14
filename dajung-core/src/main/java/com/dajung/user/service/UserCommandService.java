package com.dajung.user.service;

import com.dajung.user.port.LoadUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCommandService {

    private final LoadUserPort loadUserPort;

    public void create() {

    }

}
