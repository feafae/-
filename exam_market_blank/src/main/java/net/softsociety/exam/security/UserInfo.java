package net.softsociety.exam.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import net.softsociety.exam.domain.Member;

@Data
public class UserInfo implements UserDetails {
	
	private Member member; 

	public UserInfo(Member member) {
        this.member = member;
    }
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// �궗�슜�옄�쓽 沅뚰븳�쓣 由ы꽩
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                
                return member.getRolename().name();
            }
        });
        return collect;
	}

	@Override
	public String getPassword() {
		return member.getMemberpw();
	}

	@Override
	public String getUsername() {
		return member.getMemberid();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
