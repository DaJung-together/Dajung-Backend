package com.dajung.controller.user;

import com.dajung.user.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserQueryService userQueryService;

    public void test() {
    }
}
