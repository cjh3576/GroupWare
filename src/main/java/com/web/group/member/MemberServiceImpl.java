package com.web.group.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	//로그인
	@Override
	public MemberVO getMember(MemberVO memberVO) {
		return memberDAO.getMember(memberVO);
	}

	//mypage
	@Override
	public MemberVO getSelect(String id) throws Exception {
		return memberDAO.getSelect(id);
	}

	//회원가입
	@Override
	@Transactional
	public int setWrite(MemberVO memberVO) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		memberVO.setPw(passwordEncoder.encode(memberVO.getPw()));
		return memberDAO.setWrite(memberVO);
	}
	//

	@Override
	public int setUpdate(MemberVO memberVO) throws Exception {
		return memberDAO.setUpdate(memberVO);
	}


	@Override
	public int setDelete(String id) throws Exception {
		return memberDAO.setDelete(id);
	}
	
	
	
}
