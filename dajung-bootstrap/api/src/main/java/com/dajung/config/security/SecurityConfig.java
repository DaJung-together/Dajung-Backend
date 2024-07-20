package com.dajung.config.security;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutFilter;

import com.dajung.config.auth.filter.ExceptionFilter;
import com.dajung.config.auth.filter.UserAuthenticationFilter;
import com.dajung.config.auth.handler.CustomLogoutHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Configuration
@Import(SecurityServiceConfig.class)
@RequiredArgsConstructor
public class SecurityConfig {

	private final ObjectMapper objectMapper;
	private final CustomLogoutHandler customLogoutHandler;
	private final HttpStatusReturningLogoutSuccessHandler logoutSuccessHandler;

	private final AuthenticationManager authenticationManager;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.cors(Customizer.withDefaults())
			.formLogin(AbstractHttpConfigurer::disable)
			.csrf(AbstractHttpConfigurer::disable)
			.httpBasic(AbstractHttpConfigurer::disable)
			.rememberMe(AbstractHttpConfigurer::disable)
			.sessionManagement(AbstractHttpConfigurer::disable)
			.logout(logout -> logout.logoutUrl("/api/v1/logout")
				.addLogoutHandler(customLogoutHandler)
				.logoutSuccessHandler(logoutSuccessHandler))
			.exceptionHandling(AbstractHttpConfigurer::disable);

		http.authorizeHttpRequests(authorize -> authorize
				.requestMatchers(
					antMatcher("/"),
					antMatcher("/swagger-ui/**"),
					antMatcher("/view/**"),
					antMatcher("/js/**"),
					antMatcher("/css/**"),
					antMatcher("/docs/**"),
					antMatcher("/actuator/**"),
					antMatcher("/error/**")
				)
				.permitAll()
				.anyRequest().authenticated()
			);

		http.addFilterBefore(new ExceptionFilter(objectMapper), LogoutFilter.class);
		http.addFilterAfter(new UserAuthenticationFilter(authenticationManager), LogoutFilter.class);

		return http.build();
	}
}
