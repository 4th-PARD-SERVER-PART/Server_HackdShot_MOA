package pard.moa.be.task.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pard.moa.be.task.entity.Task;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Long> {
    List<Task> findByProjectId(Long projectId);
}