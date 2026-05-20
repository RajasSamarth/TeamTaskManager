package com.RajasSamarth.TeamTaskManager.controller;

import com.RajasSamarth.TeamTaskManager.dto.TaskRequest;
import com.RajasSamarth.TeamTaskManager.dto.TaskStatusRequest;
import com.RajasSamarth.TeamTaskManager.entity.Task;

import com.RajasSamarth.TeamTaskManager.service.TaskService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public Task createTask(

            @RequestBody TaskRequest request,

            Authentication authentication

    ){

        return taskService.createTask(

                request,

                authentication.getName()

        );

    }

    @GetMapping("/project/{projectId}")
    public List<Task> getTasks(

            @PathVariable Long projectId

    ){

        return taskService.getProjectTasks(
                projectId
        );

    }

    @PatchMapping("/{taskId}/status")
    public Task updateStatus(

            @PathVariable Long taskId,

            @RequestBody TaskStatusRequest request,

            Authentication authentication

    ){

        return taskService.updateStatus(

                taskId,

                authentication.getName(),

                request.getStatus()

        );

    }

}
