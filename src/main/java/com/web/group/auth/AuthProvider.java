package com.web.group.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.web.group.member.MemberService;
import com.web.group.member.MemberVO;

@Component
public class AuthProvider implements AuthenticationProvider{
	@Bean
	public PasswordEncoder PasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	MemberService memberService;
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userId = authentication.getName();
		String userPw = authentication.getCredentials().toString();
		return authenticate(userId,userPw);
	}

	private Authentication authenticate(String id, String pw)throws AuthenticationException {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		MemberVO memberVO = new MemberVO(id, pw);
		memberVO = memberService.getMember(memberVO);
		String encPw = memberVO.getPw();
		if(memberVO == null || !passwordEncoder.matches(pw, encPw)) {
			return null;
		}
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		
		authList.add(new SimpleGrantedAuthority("USER")); //권한 부여
		return new MyAuthentication(id, pw, authList, memberVO);
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
