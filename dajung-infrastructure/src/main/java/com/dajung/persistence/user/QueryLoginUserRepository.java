package com.dajung.persistence.user;

import static com.dajung.account.domain.entity.QAccount.*;
import static com.dajung.user.domain.entity.QUser.*;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.dajung.user.domain.vo.LoginUser;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class QueryLoginUserRepository {

	private final JPAQueryFactory queryFactory;

	public Optional<LoginUser> findLoginUser(final String loginId) {
		return Optional.ofNullable(queryFactory.select(Projections.constructor(LoginUser.class
				, user.id
				, user.status
				, account))
			.from(account)
			.join(user).on(user.id.eq(account.userId))
			.where(
				account.email.eq(loginId)
			)
			.fetchFirst());
	}
}
