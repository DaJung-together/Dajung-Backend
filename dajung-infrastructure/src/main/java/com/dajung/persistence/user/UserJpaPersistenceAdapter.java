package com.dajung.persistence.user;

import java.util.Optional;

import com.dajung.common.exception.GlobalErrorCode;
import com.dajung.common.exception.NotFoundException;
import com.dajung.user.domain.entity.User;
import com.dajung.user.domain.vo.LoginUser;
import com.dajung.user.port.LoadUserPort;
import com.dajung.user.port.SaveUserPort;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserJpaPersistenceAdapter implements LoadUserPort, SaveUserPort {

    private final UserJpaRepository repository;
    private final QueryLoginUserRepository queryLoginUserRepository;

    @Override
    public User getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(GlobalErrorCode.NOT_FOUND_ENTITY_EXCEPTION));
    }

    @Override
    public Optional<LoginUser> findLoginUser(String loginId) {
        return queryLoginUserRepository.findLoginUser(loginId);
    }

    @Override
    public Optional<User> findByContactNumber(String contactNumber) {
        return repository.findByContactNumber(contactNumber);
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }
}
