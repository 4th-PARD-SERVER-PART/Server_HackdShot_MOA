package pard.moa.be.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pard.moa.be.project.entity.Project;

public interface ProjectRepo extends JpaRepository<Project, Long> {
}
