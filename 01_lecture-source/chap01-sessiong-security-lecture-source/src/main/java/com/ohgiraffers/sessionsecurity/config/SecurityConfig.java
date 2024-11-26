package com.ohgiraffers.sessionsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    /* comment.
    *   비밀번호를 인코딩하기 위한 Bean 생성
    *   BCrypt 객체는 비밀번호 암호화를 위해 가장 많이
    *   사용되는 알고리즘 중 하나이다.
    *  */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // 보안이 빠르고 안전
    }

}
