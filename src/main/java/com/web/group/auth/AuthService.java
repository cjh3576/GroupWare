package com.web.group.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.web.group.member.MemberDAO;
import com.web.group.member.MemberVO;

@Service
public class AuthService {
	@Autowired
	MemberDAO memberDAO;
	
	public MemberVO login(String id, String pw) {
		MemberVO memberVO = new MemberVO();
		memberVO.setId(id);
		memberVO = memberDAO.getMember(memberVO);
		
		if(memberVO == null) {
			return null;
		}
		if(!memberVO.getPw().equals(pw)) {
			return null;
		}
		return memberVO;
	}
	
	public static MemberVO getCurrentUser() {
		Authentication authentication = (Authentication)SecurityContextHolder.getContext().getAuthentication();
		if(authentication instanceof MyAuthentication)
			return ((MyAuthentication) authentication).getMemberVO();
		return null;
	}
	public static void SetCurrentUser(MemberVO memberVO) {
		((MyAuthentication) SecurityContextHolder.getContext().getAuthentication()).setMemberVO(memberVO);
	}
}
