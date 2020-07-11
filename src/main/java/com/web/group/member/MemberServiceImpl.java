package com.web.group.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDAO memberDAO;
	
	
	@Override
	public List<MemberVO> selectListMember() throws Exception {
		return memberDAO.selectListMember();
	}


	@Override
	public MemberVO login(MemberVO memberVO) throws Exception {
		return memberDAO.login(memberVO);
	}


	@Override
	public MemberVO getMember(MemberVO memberVO) {
		return memberDAO.getMember(memberVO);
	}

	//mypage
	@Override
	public MemberVO getSelect(String id) throws Exception {
		return memberDAO.getSelect(id);
	}
	
	
	
}
