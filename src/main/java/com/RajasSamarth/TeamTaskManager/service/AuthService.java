package com.RajasSamarth.TeamTaskManager.service;

import com.RajasSamarth.TeamTaskManager.dto.*;

public interface AuthService {

    void register(RegisterRequest request);

    AuthResponse login(AuthRequest request);

}