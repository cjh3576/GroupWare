package com.web.group.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

public interface MemberService {
	List<MemberVO> selectListMember() throws Exception;
	
	MemberVO getMember(MemberVO memberVO);
	//login
	MemberVO login(MemberVO memberVO) throws Exception;
	//mypage
	MemberVO getSelect(String id) throws Exception;
	//회원 가입
	int setWrite(MemberVO memberVO,HttpSession session, MultipartFile multipartFile) throws Exception;
	//회원수정
	int setUpdate(MemberVO memberVO) throws Exception;
	//회원탈퇴
	int setDelete(String id) throws Exception;
}
