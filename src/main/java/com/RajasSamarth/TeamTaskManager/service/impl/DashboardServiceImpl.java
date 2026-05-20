package com.RajasSamarth.TeamTaskManager.service.impl;


import com.RajasSamarth.TeamTaskManager.dto.
        DashboardResponse;

import com.RajasSamarth.TeamTaskManager.entity.
        TaskStatus;

import com.RajasSamarth.TeamTaskManager.repository.
        TaskRepository;

import com.RajasSamarth.TeamTaskManager.service.
        DashboardService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl
        implements DashboardService {

    private final TaskRepository
            taskRepository;

    @Override
    public DashboardResponse
    getDashboard(){

        return DashboardResponse
                .builder()

                .totalTasks(
                        taskRepository.count()
                )

                .completedTasks(
                        taskRepository.countByStatus(
                                TaskStatus.DONE
                        )
                )

                .inProgressTasks(
                        taskRepository.countByStatus(
                                TaskStatus.IN_PROGRESS
                        )
                )

                .todoTasks(
                        taskRepository.countByStatus(
                                TaskStatus.TODO
                        )
                )

                .overdueTasks(

                        taskRepository
                                .countByDueDateBeforeAndStatusNot(

                                        LocalDate.now(),

                                        TaskStatus.DONE

                                )

                )

                .build();

    }

}
