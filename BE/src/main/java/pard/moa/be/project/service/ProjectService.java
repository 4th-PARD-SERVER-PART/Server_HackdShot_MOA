package pard.moa.be.project.service;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pard.moa.be.project.dto.ProjectRequestDto;
import pard.moa.be.project.dto.ProjectResponseDto;
import pard.moa.be.project.entity.Project;
import pard.moa.be.project.repo.ProjectRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepo projectRepo;


    // Create a new project
    public void createProject(ProjectRequestDto request) {
        Long userId = 1L; // Hardcoded User ID
        Project project = new Project(request.getName(), userId);
        projectRepo.save(project);
    }

    // Fetch all projects
    public List<ProjectResponseDto> getAllProjects() {
        return projectRepo.findAll().stream()
                .map(ProjectResponseDto::from)
                .collect(Collectors.toList());
    }

    // Update project name
    public void updateProject(Long projectId, ProjectRequestDto request) {
        Project project = projectRepo.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));
        project.setName(request.getName());
        projectRepo.save(project);
    }
}