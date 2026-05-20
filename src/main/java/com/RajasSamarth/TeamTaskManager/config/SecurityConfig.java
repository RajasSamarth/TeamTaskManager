package com.RajasSamarth.TeamTaskManager.config;

import com.RajasSamarth.TeamTaskManager.security.JwtFilter;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.*;
import org.springframework.security.authentication.
        AuthenticationManager;

import org.springframework.security.config.annotation.
        authentication.configuration.
        AuthenticationConfiguration;

import org.springframework.security.config.annotation.web.
        builders.HttpSecurity;

import org.springframework.security.config.http.
        SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.
        BCryptPasswordEncoder;

import org.springframework.security.crypto.password.
        PasswordEncoder;

import org.springframework.security.web.
        SecurityFilterChain;

import org.springframework.security.web.
        authentication.
        UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    @Bean
    PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager
    authenticationManager(
            AuthenticationConfiguration config
    ) throws Exception {

        return config.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain securityFilterChain(
            HttpSecurity http
    ) throws Exception {

        http
                .cors(cors->{})
                .csrf(csrf->csrf.disable())

                .authorizeHttpRequests(auth -> auth

                        .requestMatchers(
                                "/api/auth/**"
                        )
                        .permitAll()

                        .requestMatchers(
                                "/api/projects/**"
                        )
                        .hasRole("ADMIN")

                        .requestMatchers(
                                "/api/tasks/**",
                                "/api/dashboard/**"
                        )
                        .authenticated()

                        .anyRequest()
                        .authenticated()

                )

                .sessionManagement(session ->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS
                        )
                )

                .addFilterBefore(
                        jwtFilter,
                        UsernamePasswordAuthenticationFilter.class
                );

        return http.build();
    }

}