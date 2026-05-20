package com.RajasSamarth.TeamTaskManager.repository;

import com.RajasSamarth.TeamTaskManager.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository
        extends JpaRepository<Project,Long> {

}