package com.RajasSamarth.TeamTaskManager.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DashboardResponse {

    private Long totalTasks;

    private Long completedTasks;

    private Long inProgressTasks;

    private Long todoTasks;

    private Long overdueTasks;

}