package com.RajasSamarth.TeamTaskManager.service;

import com.RajasSamarth.TeamTaskManager.dto.TaskRequest;
import com.RajasSamarth.TeamTaskManager.entity.Task;
import com.RajasSamarth.TeamTaskManager.entity.TaskStatus;

import java.util.List;

public interface TaskService {

    Task createTask(
            TaskRequest request,
            String creatorEmail
    );

    List<Task> getProjectTasks(
            Long projectId
    );

    Task updateStatus(
            Long taskId,
            String email,
            TaskStatus status
    );
}
