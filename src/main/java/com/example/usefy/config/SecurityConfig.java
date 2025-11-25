package com.example.usefy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/auth/**", "/h2-console/**", "/home/**").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin.permitAll()) // Enable form login
                .logout(logout -> logout.permitAll()); // Enable logout

        return http.build();
    }
}
