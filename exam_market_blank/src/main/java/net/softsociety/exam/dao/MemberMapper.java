package net.softsociety.exam.dao;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.exam.domain.Member;

/**
 * �쉶�썝�젙蹂� 愿��젴 留ㅽ띁
 */
@Mapper
public interface MemberMapper {
	public int saveMember(Member member);
	public Member findMemberById(String id);
	public Member findMemberByIdAndPassword(Member member);
	public int updateMember(Member member);
}
