package pard.moa.be.task.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pard.moa.be.task.dto.TaskRequestDto;
import pard.moa.be.task.dto.TaskResponseDto;
import pard.moa.be.task.service.TaskService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    // Create a new task
    @PostMapping("/{projectId}")
    @Operation(summary = "Task 추가/생성", description = "선택된 project 에서 task 추가하기")
    public ResponseEntity<String> createTask(@PathVariable Long projectId, @RequestBody TaskRequestDto.TaskCreateRequest req) {
        taskService.createTask(projectId, req);
        return ResponseEntity.ok("Task created successfully");
    }

    // Get all tasks by project
    @GetMapping("/{projectId}")
    @Operation(summary = "Task 추가/생성")
    public ResponseEntity<List<TaskResponseDto.TaskRead>> getTasksByProject(@PathVariable Long projectId) {
        return ResponseEntity.ok(taskService.findTasksByProject(projectId));
    }

    // Update a task
    @PatchMapping("/{taskId}")
    @Operation(summary = "Task 추가/생성", description = "project id 상관 없이 그냥 task id 로 바로 수정 가능")
    public ResponseEntity<String> updateTask(@PathVariable Long taskId, @RequestBody TaskRequestDto.TaskCreateRequest req) {
        taskService.updateTask(taskId, req);
        return ResponseEntity.ok("Task updated successfully");
    }

    // Delete a task
    @DeleteMapping("/{taskId}")
    @Operation(summary = "Task 삭제", description = "그 project id 상관없이 그냥 task id 로 바로 삭제 할 수 있게 했어요")
    public ResponseEntity<String> deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok("Task deleted successfully");
    }
}
