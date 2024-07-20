package com.dajung.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dajung.common.crypto.Aes256Crypto;

@Configuration
public class CryptoConfig {

	@Bean
	public Aes256Crypto aes256Crypto(@Value("${key}") String key) {
		return new Aes256Crypto(key);
	}
}
