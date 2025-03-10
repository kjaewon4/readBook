package com.book.book.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // CSRF 비활성화 (프론트엔드 연동 시 필요)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/signup").permitAll() // 로그인하지 않은 사용자도 접근 가능
                        .anyRequest().authenticated() // 나머지는 인증 필요
                )
                .formLogin(form -> form
                        .loginProcessingUrl("/login") // Spring Security가 로그인 처리
                        .usernameParameter("userName") // 프론트엔드에서 보낸 userName을 매핑
                        .passwordParameter("userPassword") // 프론트엔드에서 보낸 userPassword를 매핑
                        .defaultSuccessUrl("/", true) // 로그인 성공 시 이동할 경로
                        .failureUrl("/login?error=true") // 로그인 실패 시 이동할 경로
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // 로그아웃 처리
                        .logoutSuccessUrl("/") // 로그아웃 성공 후 이동할 경로
                        .permitAll()
                );

        return http.build();
    }
}
