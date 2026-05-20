package com.RajasSamarth.TeamTaskManager.service.impl;

import com.RajasSamarth.TeamTaskManager.dto.ProjectRequest;
import com.RajasSamarth.TeamTaskManager.entity.Project;
import com.RajasSamarth.TeamTaskManager.entity.User;
import com.RajasSamarth.TeamTaskManager.repository.ProjectRepository;
import com.RajasSamarth.TeamTaskManager.repository.UserRepository;
import com.RajasSamarth.TeamTaskManager.service.ProjectService;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl
        implements ProjectService {

    private final ProjectRepository projectRepository;

    private final UserRepository userRepository;

    @Override
    public Project createProject(
            ProjectRequest request,
            String email
    ){

        User creator=
                userRepository.findByEmail(email)
                        .orElseThrow();

        Project project=
                Project.builder()
                        .name(request.getName())
                        .description(request.getDescription())
                        .createdBy(creator)
                        .createdAt(LocalDateTime.now())
                        .build();

        return projectRepository.save(project);

    }

    @Override
    public List<Project> getProjects(){

        return projectRepository.findAll();

    }

    @Override
    public Project addMember(
            Long projectId,
            Long userId
    ){

        Project project =
                projectRepository
                        .findById(projectId)
                        .orElseThrow();

        User user =
                userRepository
                        .findById(userId)
                        .orElseThrow();

        if(project.getMembers()==null){

            project.setMembers(
                    new ArrayList<>()
            );

        }

        project.getMembers().add(user);

        return projectRepository.save(project);

    }
}
