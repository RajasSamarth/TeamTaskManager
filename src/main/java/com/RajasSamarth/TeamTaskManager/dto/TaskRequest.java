package com.RajasSamarth.TeamTaskManager.dto;

import com.RajasSamarth.TeamTaskManager.entity.Priority;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TaskRequest {

    private String title;

    private String description;

    private Priority priority;

    private LocalDate dueDate;

    private Long assignedUserId;

    private Long projectId;

}
