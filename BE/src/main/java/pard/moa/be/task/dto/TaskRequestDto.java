package pard.moa.be.task.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class TaskRequestDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TaskCreateRequest {
        @NotBlank
        private String title;
    }
}