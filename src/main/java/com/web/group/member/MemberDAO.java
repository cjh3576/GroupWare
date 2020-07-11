package com.web.group.member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDAO {
	public List<MemberVO> selectListMember();
	
	public MemberVO getMember(MemberVO memberVO);
	//login
	public MemberVO login(MemberVO memberVO);
	//my page
	public MemberVO getSelect(String id);
}
