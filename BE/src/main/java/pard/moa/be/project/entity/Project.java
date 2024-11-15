package pard.moa.be.project.entity;


import jakarta.persistence.*;
import lombok.*;
import pard.moa.be.member.entity.Member;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long userId;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Member> members; // List of Members linked to the Project

    public Project(String name, Long userId) {
        this.name = name;
        this.userId = userId;
    }
}
