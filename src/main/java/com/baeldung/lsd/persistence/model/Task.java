package com.baeldung.lsd.persistence.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDate dueDate;
    private TaskStatus status;

    @Column(unique = true, nullable = false, updatable = false)
    private String uuid = UUID.randomUUID().toString();


    public Task(String name, String description, LocalDate dueDate, Project project, TaskStatus taskStatus) {
    }


    @Override
    public boolean equals (Object obj) {

        if (this == obj) {
            return  true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Task other = (Task) obj;
        if (uuid == null) {
            if (other.uuid != null)
                return false;
        } else if (!uuid.equals(other.uuid))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    @ManyToOne(optional = false)
    private Project project;

    public Task(String name, String description, LocalDate dueDate, Project project) {
        this(name, description, dueDate, project, TaskStatus.TO_DO);
    }

    @ManyToOne
    private Worker assignee;
}
