package com.web.group.auth;

import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import com.web.group.member.MemberVO;

public class MyAuthentication extends UsernamePasswordAuthenticationToken{

	private static final long serialVersionUID = 1L;

	MemberVO memberVO;
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	public MyAuthentication(String id, String pw, List<GrantedAuthority> authList, MemberVO memberVO) {
		super(id, pw, authList);
		this.memberVO = memberVO;
	}

}
