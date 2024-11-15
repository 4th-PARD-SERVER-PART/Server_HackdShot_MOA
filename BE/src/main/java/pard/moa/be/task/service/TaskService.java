package pard.moa.be.task.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pard.moa.be.project.entity.Project;
import pard.moa.be.project.repo.ProjectRepo;
import pard.moa.be.task.dto.TaskRequestDto;
import pard.moa.be.task.dto.TaskResponseDto;
import pard.moa.be.task.entity.Task;
import pard.moa.be.task.repo.TaskRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepo taskRepo;
    private final ProjectRepo projectRepo;

    // Create a new task
    @Transactional
    public void createTask(Long projectId, TaskRequestDto.TaskCreateRequest req) {
        Project project = projectRepo.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));

        Task task = new Task(req.getTitle(), project);
        taskRepo.save(task);
    }

    // Get all tasks by project
    public List<TaskResponseDto.TaskRead> findTasksByProject(Long projectId) {
        if (!projectRepo.existsById(projectId)) {
            throw new IllegalArgumentException("Project not found");
        }

        return taskRepo.findByProjectId(projectId).stream()
                .map(TaskResponseDto.TaskRead::from)
                .collect(Collectors.toList());
    }

    // Update task
    @Transactional
    public void updateTask(Long taskId, TaskRequestDto.TaskCreateRequest req) {
        Task task = taskRepo.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));

        task.setTitle(req.getTitle());
        taskRepo.save(task);
    }

    // Delete task
    @Transactional
    public void deleteTask(Long taskId) {
        if (!taskRepo.existsById(taskId)) {
            throw new IllegalArgumentException("Task not found");
        }

        taskRepo.deleteById(taskId);
    }
}
