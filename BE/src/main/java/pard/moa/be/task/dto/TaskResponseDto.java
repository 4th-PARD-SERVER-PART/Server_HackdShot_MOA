package pard.moa.be.task.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pard.moa.be.task.entity.Task;


@Getter
public class TaskResponseDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TaskRead {
        private Long id;
        private String title;
        private Long projectId;

        // Converts Task entity to TaskRead DTO
        public static TaskRead from(Task task) {
            return new TaskRead(
                    task.getId(),
                    task.getTitle(),
                    task.getProject().getId()
            );
        }
    }
}