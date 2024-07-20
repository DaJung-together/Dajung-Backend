package com.dajung.persistence;

import com.dajung.persistence.user.UserJpaPersistenceAdapter;
import com.dajung.persistence.user.UserJpaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Import(AdapterTest.AdapterTestConfig.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public abstract class AdapterTest {

    @PersistenceContext
    protected EntityManager entityManager;

    @TestConfiguration
    public static class AdapterTestConfig {

        // User
        @Bean
        public UserJpaPersistenceAdapter accountPersistenceAdapter(UserJpaRepository userJpaRepository) {
            return new UserJpaPersistenceAdapter(userJpaRepository);
        }

    }

}
