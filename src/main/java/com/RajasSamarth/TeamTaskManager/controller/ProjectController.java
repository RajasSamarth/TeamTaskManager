package com.RajasSamarth.TeamTaskManager.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.RajasSamarth.TeamTaskManager.dto.ProjectRequest;
import com.RajasSamarth.TeamTaskManager.entity.Project;
import com.RajasSamarth.TeamTaskManager.service.ProjectService;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public Project createProject(
            @RequestBody ProjectRequest request,
            Authentication authentication
    ){

        return projectService.createProject(
                request,
                authentication.getName()
        );

    }

    @GetMapping
    public List<Project> getProjects(){

        return projectService.getProjects();

    }

    @PostMapping(
            "/{projectId}/members/{userId}"
    )
    public Project addMember(

            @PathVariable
            Long projectId,

            @PathVariable
            Long userId

    ){

        return projectService
                .addMember(
                        projectId,
                        userId
                );

    }

}
