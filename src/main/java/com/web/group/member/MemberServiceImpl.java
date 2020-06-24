package com.web.group.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDAO memberDAO;
	
	
	@Override
	public List<MemberVO> selectListMember() {
		return memberDAO.selectListMember();
	}
}
