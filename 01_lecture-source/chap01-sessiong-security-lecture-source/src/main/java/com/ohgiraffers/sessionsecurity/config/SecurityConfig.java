package com.ohgiraffers.sessionsecurity.config;

import com.ohgiraffers.sessionsecurity.common.UserRole;
import org.apache.catalina.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
/* comment. spring security 기능 활성화를 위한 어노테이션 */
@EnableWebSecurity
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

    /* comment. 여기가 설정의 핵심 */
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) {
        // 서버의 리소스 접근 가능 권한 설정
        http.authorizeHttpRequests(auth -> {
            // permitAll() -> 인증 되지 않은(로그인 되지 않은) 사용자들이 접근할 수 있는 URL 기술
            auth.requestMatchers("auth/login", "/user/signup", "auth/fail", "/").permitAll();
            // hasAnyAuthority -> 해당하는 URL 은 권한을 가진 사람만 접근할 수 있다.
            auth.requestMatchers("/admin/*").hasAnyAuthority(UserRole.ADMIN.getRole());
            // /user/* 요청은 일반회원 권한을 가진 사람만 접근할 수 있다.
            auth.requestMatchers("/user/*").hasAnyAuthority(UserRole.USER.getRole());
            // 그 외 어떠한 요청들은 권한상관 없이 들어갈 수 있다. (단, 로그인 된 인원에 한해)
            auth.anyRequest().authenticated();
        }).formLogin(login -> {
            login.loginPage("/auth/login");  // 로그인 페이지 url 을 기술
            // 사용자가 ID 를 입력하는 필드(input 타입 name 과 반드시 일치해야 한다.)
            login.usernameParameter("user");
        })
     }

}
