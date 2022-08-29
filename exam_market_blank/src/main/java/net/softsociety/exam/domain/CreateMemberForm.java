package net.softsociety.exam.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class CreateMemberForm {
    private String memberid;
    private String membername;
    private String memberpw;
    private String phone;
    private RoleType rolename;
    private boolean enabled;

    public Member toMember() {
        Member member = new Member();
        member.setEnabled(enabled);
        member.setMemberid(memberid);
        member.setMembername(membername);
        member.setMemberpw(memberpw);
        member.setPhone(phone);
        member.setRolename(rolename);
        return member;
    }
}
