package pard.moa.be.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pard.moa.be.member.dto.MemberResponseDto;
import pard.moa.be.member.repo.MemberRepo;
import pard.moa.be.member.entity.Member;
import pard.moa.be.project.entity.Project;
import pard.moa.be.project.repo.ProjectRepo;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepo memberRepo;
    private final ProjectRepo projectRepo;

    // Add a member to a project
    public void addMember(Long projectId, String memberName) {
        Project project = projectRepo.findById(projectId).orElseThrow(() -> new IllegalArgumentException("Project not found"));

        Member member = new Member(memberName, project);
        memberRepo.save(member);
    }

    // Fetch all members of a project
    public List<MemberResponseDto> getMembersByProjectId(Long projectId) {
        if (!projectRepo.existsById(projectId)) {
            throw new IllegalArgumentException("Project not found");
        }

        return memberRepo.findByProjectId(projectId).stream().map(MemberResponseDto::from).collect(Collectors.toList());
    }
}