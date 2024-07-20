package com.dajung.persistence.user;


import java.util.Optional;

import com.dajung.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {

	Optional<User> findByContactNumber(String contactNumber);
}
