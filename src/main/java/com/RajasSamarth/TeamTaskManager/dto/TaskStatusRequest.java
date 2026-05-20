package com.RajasSamarth.TeamTaskManager.dto;

import com.RajasSamarth.TeamTaskManager.entity.TaskStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskStatusRequest {

    private TaskStatus status;

}