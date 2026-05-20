package com.RajasSamarth.TeamTaskManager.service.impl;

import com.RajasSamarth.TeamTaskManager.dto.TaskRequest;
import com.RajasSamarth.TeamTaskManager.entity.*;

import com.RajasSamarth.TeamTaskManager.repository.*;

import com.RajasSamarth.TeamTaskManager.service.TaskService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl
        implements TaskService {

    private final TaskRepository taskRepository;

    private final UserRepository userRepository;

    private final ProjectRepository projectRepository;

    @Override
    public Task createTask(
            TaskRequest request,
            String creatorEmail
    ){

        User creator=
                userRepository
                        .findByEmail(creatorEmail)
                        .orElseThrow();

        User assignedUser=
                userRepository
                        .findById(
                                request.getAssignedUserId()
                        )
                        .orElseThrow();

        Project project=
                projectRepository
                        .findById(
                                request.getProjectId()
                        )
                        .orElseThrow();

        Task task=Task.builder()
                .title(request.getTitle())
                .description(
                        request.getDescription()
                )
                .priority(
                        request.getPriority()
                )
                .status(TaskStatus.TODO)
                .dueDate(
                        request.getDueDate()
                )
                .assignedTo(
                        assignedUser
                )
                .project(project)
                .createdBy(creator)
                .createdAt(
                        LocalDateTime.now()
                )
                .build();

        return taskRepository.save(task);

    }

    @Override
    public List<Task> getProjectTasks(
            Long projectId
    ){

        return taskRepository
                .findByProjectId(projectId);

    }

    @Override
    public Task updateStatus(
            Long taskId,
            String email,
            TaskStatus status
    ){

        Task task=
                taskRepository
                        .findById(taskId)
                        .orElseThrow();

        if(
                !task.getAssignedTo()
                        .getEmail()
                        .equals(email)
        ){

            throw new RuntimeException(
                    "Only assigned member can update task"
            );

        }

        task.setStatus(status);

        return taskRepository.save(task);

    }

}