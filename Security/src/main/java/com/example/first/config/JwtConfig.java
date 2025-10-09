package com.example.first.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.first.token.JwtUtil;

@Configuration
public class JwtConfig {
	
	@Bean
	public JwtUtil jwtUtil() {
		return new JwtUtil();
	}

}
