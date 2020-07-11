package com.web.group.member;

import java.util.List;

public interface MemberService {
	List<MemberVO> selectListMember() throws Exception;
	
	MemberVO getMember(MemberVO memberVO);
	//login
	MemberVO login(MemberVO memberVO) throws Exception;
	//mypage
	MemberVO getSelect(String id) throws Exception;
}
