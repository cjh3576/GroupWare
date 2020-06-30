package com.web.group.member;

import java.util.List;

public interface MemberService {
	List<MemberVO> selectListMember() throws Exception;
	
	//login
	MemberVO login(MemberVO memberVO) throws Exception;
}
