package com.fisa.kafrika_backend.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/ws/**").permitAll()  // WebSocket 엔드포인트 허용
                .requestMatchers("/actuator/**").permitAll()  // Actuator 엔드포인트 허용
                .requestMatchers("/user/**").permitAll()  // 사용자 API 허용
                .requestMatchers("/chat/**").permitAll()  // 채팅 API 허용
                .anyRequest().authenticated()
            )
            .csrf(csrf -> csrf.disable())  // CSRF 비활성화 (WebSocket용)
            .headers(headers -> headers.frameOptions().disable());  // X-Frame-Options 비활성화

        return http.build();
    }
}