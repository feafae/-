package net.softsociety.exam.service;

import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;
import net.softsociety.exam.dao.MemberMapper;
import net.softsociety.exam.domain.Member;

/** 
 * �쉶�썝�젙蹂� 愿��젴 �꽌鍮꾩뒪
 */
@RequiredArgsConstructor
@Service
public class MemberService {
	private final MemberMapper memberMapper;
	
	public void saveMember(Member member) {
        memberMapper.saveMember(member);
    }
	public Member findMember(String id) {
        return memberMapper.findMemberById(id);
    }
	public Member findMember(Member member) {
        return memberMapper.findMemberByIdAndPassword(member);
    }
	public void updateMember(Member member) {
        memberMapper.updateMember(member);
    }
	
}
