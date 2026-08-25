package com.kisan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth

                        // =========================
                        // PUBLIC AUTHENTICATION
                        // =========================
                        .requestMatchers(
                                "/api/register",
                                "/api/login"
                        ).permitAll()

                        // =========================
                        // PUBLIC MARKETPLACE
                        // =========================
                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/products",
                                "/api/products/**"
                        ).permitAll()

                        // =========================
                        // PUBLIC SUPPLIERS
                        // =========================
                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/suppliers",
                                "/api/suppliers/**"
                        ).permitAll()

                        // =========================
                        // PUBLIC TRANSPORTERS
                        // =========================
                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/transporters",
                                "/api/transporters/**"
                        ).permitAll()

                        // =========================
                        // PUBLIC NEWS
                        // =========================
                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/news",
                                "/api/news/**"
                        ).permitAll()

                        // =========================
                        // PUBLIC KNOWLEDGE
                        // =========================
                        .requestMatchers(
                                HttpMethod.GET,
                                "/api/knowledge/diseases",
                                "/api/knowledge/skills"
                        ).permitAll()

                        // =========================
                        // PUBLIC CONTACT
                        // =========================
                        .requestMatchers(
                                HttpMethod.POST,
                                "/api/messages"
                        ).permitAll()

                        // =========================
                        // EVERYTHING ELSE
                        // =========================
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}