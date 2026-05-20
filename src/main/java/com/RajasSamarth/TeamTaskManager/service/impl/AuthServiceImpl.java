package com.RajasSamarth.TeamTaskManager.service.impl;

import com.RajasSamarth.TeamTaskManager.dto.*;
import com.RajasSamarth.TeamTaskManager.entity.User;
import com.RajasSamarth.TeamTaskManager.repository.
        UserRepository;

import com.RajasSamarth.TeamTaskManager.security.
        JwtService;

import com.RajasSamarth.TeamTaskManager.service.
        AuthService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.
        PasswordEncoder;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl
        implements AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    @Override
    public void register(RegisterRequest request){

        User user=User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(
                        passwordEncoder.encode(
                                request.getPassword()
                        )
                )
                .role(request.getRole())
                .build();

        userRepository.save(user);
    }

    @Override
    public AuthResponse login(
            AuthRequest request
    ){

        User user=
                userRepository
                        .findByEmail(request.getEmail())
                        .orElseThrow();

        if(!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        )){
            throw new RuntimeException(
                    "Invalid Password"
            );
        }

        String token=
                jwtService.generateToken(
                        user.getEmail()
                );

        return new AuthResponse(token);

    }

}