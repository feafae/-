package net.softsociety.exam.domain;

import lombok.Data;


@Data
public class LoginForm {
    private String memberid;
    private String memberpw;

    public Member toMember() {
        Member member = new Member();
        member.setMemberid(memberid);
        member.setMemberpw(memberpw);;
        return member;
    }
}
