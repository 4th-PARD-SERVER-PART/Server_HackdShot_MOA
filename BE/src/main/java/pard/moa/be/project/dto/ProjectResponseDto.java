package pard.moa.be.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pard.moa.be.project.entity.Project;

@Getter
@AllArgsConstructor
public class ProjectResponseDto {
    private Long id;
    private String name;
    private Long userId;

    public static ProjectResponseDto from(Project project) {
        return new ProjectResponseDto(project.getId(), project.getName(), project.getUserId());
    }
}
