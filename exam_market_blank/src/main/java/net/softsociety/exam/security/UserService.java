package net.softsociety.exam.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;
import net.softsociety.exam.dao.MemberMapper;
import net.softsociety.exam.domain.Member;


@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
	
	private final MemberMapper memberDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Member member = memberDAO.findMemberById(username);
		if (member != null) {
            return new UserInfo(member);
        }
		return null;
	}

}
