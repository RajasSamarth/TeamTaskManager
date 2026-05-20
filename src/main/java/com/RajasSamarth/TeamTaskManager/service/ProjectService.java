package com.RajasSamarth.TeamTaskManager.service;

import com.RajasSamarth.TeamTaskManager.dto.ProjectRequest;
import com.RajasSamarth.TeamTaskManager.entity.Project;

import java.util.List;

public interface ProjectService {

    Project createProject(
            ProjectRequest request,
            String email
    );

    List<Project> getProjects();

    Project addMember(
            Long projectId,
            Long userId
    );
}