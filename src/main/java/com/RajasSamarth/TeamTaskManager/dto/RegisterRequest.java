package com.RajasSamarth.TeamTaskManager.dto;

import com.RajasSamarth.TeamTaskManager.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    private String name;

    private String email;

    private String password;

    private Role role;
}