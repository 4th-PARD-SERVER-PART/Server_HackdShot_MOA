package pard.moa.be.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pard.moa.be.member.entity.Member;

@Getter
@AllArgsConstructor
public class MemberResponseDto {
    private Long id;
    private String name;

    public static MemberResponseDto from(Member member) {
        return new MemberResponseDto(member.getId(), member.getName());
    }
}