package com.RajasSamarth.TeamTaskManager.controller;

import com.RajasSamarth.TeamTaskManager.dto.
        DashboardResponse;

import com.RajasSamarth.TeamTaskManager.service.
        DashboardService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService
            dashboardService;

    @GetMapping
    public DashboardResponse
    dashboard(){

        return dashboardService
                .getDashboard();

    }

}