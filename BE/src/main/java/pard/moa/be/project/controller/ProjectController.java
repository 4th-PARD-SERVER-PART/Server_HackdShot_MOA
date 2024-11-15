package pard.moa.be.project.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pard.moa.be.member.dto.MemberResponseDto;
import pard.moa.be.member.service.MemberService;
import pard.moa.be.project.dto.ProjectRequestDto;
import pard.moa.be.project.service.ProjectService;
import pard.moa.be.project.dto.ProjectResponseDto;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;
    private final MemberService memberService;

    // Create a new project
    @PostMapping
    @Operation(summary = "Project 추가/생성", description = "front 에서는 name 만 받고 userId 랑 projectId는 자동생성")
    public ResponseEntity<String> createProject(@RequestBody ProjectRequestDto request) {
        projectService.createProject(request);
        return ResponseEntity.ok("Project created successfully");
    }

    // Fetch all projects
    @GetMapping
    @Operation(summary = "모든 Projects 불러오기")
    public ResponseEntity<List<ProjectResponseDto>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    // Update project name
    @PatchMapping("/{projectId}")
    @Operation(summary = "Project name 수정", description = "해당 project ID 의 이름을 수정")
    public ResponseEntity<String> updateProject(@PathVariable Long projectId, @RequestBody ProjectRequestDto request) {
        projectService.updateProject(projectId, request);
        return ResponseEntity.ok("Project updated successfully");
    }

    //Post members
    @PostMapping("/{projectId}/members")
    @Operation(summary = "member 추가하기 룰루...")
    public ResponseEntity<String> addMember(@PathVariable Long projectId, @RequestParam String name) {
        memberService.addMember(projectId, name);
        return ResponseEntity.ok("Member added successfully");
    }

    // Get all members of a project
    @GetMapping("/{projectId}/members")
    @Operation(summary = "Get Members", description = "해당 project id 의 모든 member 불러오기")
    public ResponseEntity<List<MemberResponseDto>> getMembers(@PathVariable Long projectId) {
        List<MemberResponseDto> members = memberService.getMembersByProjectId(projectId);
        return ResponseEntity.ok(members);
    }
}