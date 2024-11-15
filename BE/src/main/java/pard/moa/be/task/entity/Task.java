package pard.moa.be.task.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pard.moa.be.project.entity.Project;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false) // Foreign key to Project
    private Project project;

    public Task(String title, Project project) {
        this.title = title;
        this.project = project;
    }


}
