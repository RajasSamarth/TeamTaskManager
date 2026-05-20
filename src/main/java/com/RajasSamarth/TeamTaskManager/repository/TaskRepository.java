package com.RajasSamarth.TeamTaskManager.repository;

import com.RajasSamarth.TeamTaskManager.entity.Task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository
        extends JpaRepository<Task,Long>{

    List<Task> findByAssignedToId(Long userId);

    List<Task> findByProjectId(Long projectId);

    List<Task> findByDueDateBeforeAndStatusNot(
            LocalDate date,
            com.RajasSamarth.TeamTaskManager.entity.TaskStatus status
    );

    long count();

    long countByStatus(
            com.RajasSamarth.TeamTaskManager.entity.TaskStatus status
    );

    long countByDueDateBeforeAndStatusNot(
            LocalDate date,
            com.RajasSamarth.TeamTaskManager.entity.TaskStatus status
    );

}