package com.dajung.persistence.user;

import com.dajung.common.exception.GlobalErrorCode;
import com.dajung.common.exception.NotFoundException;
import com.dajung.user.domain.entity.User;
import com.dajung.user.domain.vo.UserStatus;
import com.dajung.user.port.LoadUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserJpaPersistenceAdapter implements LoadUserPort{

    private final UserJpaRepository repository;

    @Override
    public User getById(Long id) {
        return repository.findByIdAndStatus(id, UserStatus.ACTIVE)
                .orElseThrow(() -> new NotFoundException(GlobalErrorCode.NOT_FOUND_ENTITY_EXCEPTION));
    }

}
