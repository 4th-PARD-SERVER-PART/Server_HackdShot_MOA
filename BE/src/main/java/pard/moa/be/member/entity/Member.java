package pard.moa.be.member.entity;

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
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Member ID (auto-generated)

    private String name;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false) // Foreign key to Project
    private Project project;

    public Member(String name, Project project) {
        this.name = name;
        this.project = project;
    }
}
