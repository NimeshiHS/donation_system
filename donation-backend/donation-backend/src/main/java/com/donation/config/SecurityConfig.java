package com.donation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity (optional)
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // Allow all requests without auth
            )
            .formLogin(form -> form.disable()) // Disable login form
            .httpBasic(basic -> basic.disable()); // Disable HTTP Basic auth

        return http.build();
    }
}
