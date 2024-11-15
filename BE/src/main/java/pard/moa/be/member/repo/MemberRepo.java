package pard.moa.be.member.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import pard.moa.be.member.entity.Member;

import java.util.List;

public interface MemberRepo extends JpaRepository<Member, Long> {
    List<Member> findByProjectId(Long projectId);
}
