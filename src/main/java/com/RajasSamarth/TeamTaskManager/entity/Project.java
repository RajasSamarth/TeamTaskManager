package com.RajasSamarth.TeamTaskManager.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name="created_by")
    private User createdBy;

    @ManyToMany
    @JoinTable(
            name="project_members",
            joinColumns=@JoinColumn(name="project_id"),
            inverseJoinColumns=@JoinColumn(name="user_id")
    )
    private List<User> members;

    @JsonManagedReference
    @OneToMany(
            mappedBy="project",
            cascade=CascadeType.ALL
    )
    private List<Task> tasks;

    private LocalDateTime createdAt;


}