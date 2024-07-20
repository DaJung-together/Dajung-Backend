package com.dajung.persistence.user;


import com.dajung.user.domain.entity.User;
import com.dajung.user.domain.vo.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    Optional<User> findByIdAndStatus(Long id, UserStatus status);

}
