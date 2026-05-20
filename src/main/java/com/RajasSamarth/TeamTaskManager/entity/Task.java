package com.RajasSamarth.TeamTaskManager.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    private LocalDate dueDate;

    @JsonIgnoreProperties({
            "password",
            "members",
            "tasks"
    })
    @ManyToOne
    @JoinColumn(name="assigned_to")
    private User assignedTo;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;

    @JsonIgnoreProperties({
            "password",
            "members",
            "tasks"
    })
    @ManyToOne
    @JoinColumn(name="created_by")
    private User createdBy;

    private LocalDateTime createdAt;



}