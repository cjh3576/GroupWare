package com.web.group.controller;

import java.lang.annotation.Target;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.web.group.member.MemberService;
import com.web.group.member.MemberVO;
@Controller
@RequestMapping("/member/")
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@GetMapping(value = "memberList")
	public ModelAndView selectListMember() throws Exception{
		ModelAndView mv = new ModelAndView();
		List<MemberVO> list = memberService.selectListMember();

		mv.addObject("list",list);
		mv.setViewName("member/memberList");

		return mv;
	}
	//security login
	@GetMapping(value = "login")
	public ModelAndView login() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/login");
		return mv;
	}

	//logout
	@GetMapping(value = "/logout")
	public ModelAndView logout(HttpSession session, ModelAndView mv) throws Exception{
		session.invalidate(); //무효화
		mv.setViewName("redirect:../");
		return mv;
	}


	//my page
	@GetMapping(value = "MyPage")
	public ModelAndView myPage(ModelAndView mv, Principal principal) throws Exception{
		MemberVO memberVO = null;
		String id = principal.getName();

		memberVO = memberService.getSelect(id);

		if(memberVO != null) {
			mv.addObject("memberVO", memberVO);
			mv.setViewName("member/MyPage");
		} else {
			mv.addObject("message","정보가 없습니다.");
			mv.addObject("path","redirect:../");
			mv.setViewName("common/messageMove");
		}

		return mv;
	}
	
	//회원가입
	@GetMapping(value = "memberJoin")
	public void memberJoin(@ModelAttribute MemberVO memberVO) throws Exception{}
	
	
	@PostMapping(value = "memberJoin")
	public ModelAndView memberJoin(@Validated MemberVO memberVO, ModelAndView mv) throws Exception{
		int result = memberService.setWrite(memberVO);
		if(result> 0) {
			mv.setViewName("redirect:./login");
		} else {
			mv.addObject("message","join fail");
			mv.addObject("path","../");
			mv.setViewName("common/messageMove");
		}
		
		return mv;
	}
	//회원수정
	@GetMapping(value = "memberUpdate")
	public ModelAndView memberUpdate(ModelAndView mv,MemberVO memberVO) throws Exception{
		mv.addObject("memberVO",memberVO);
		mv.setViewName("member/memberUpdate");
		return mv;
	}
	
	@PostMapping(value = "memberSetUpdate")
	public ModelAndView memberSetUpdate(ModelAndView mv,@Validated MemberVO memberVO) throws Exception{
		int result = memberService.setUpdate(memberVO);
		if(result>0) {
			mv.setViewName("redirect:./MyPage");
		} else {
			mv.addObject("message","수정을 실패하였습니다.");
			mv.addObject("path","./memberUpdate");
			mv.setViewName("common/messageMove");
		}
		
		return mv;
	}
	
	//회원탈퇴
	@GetMapping(value = "memberDelete")
	public ModelAndView memberDelete(ModelAndView mv,HttpSession session, Principal principal) throws Exception{
		String id = principal.getName();
		int result = memberService.setDelete(id);
		if(result>0) {
			mv.setViewName("redirect:../");
			session.invalidate();
		} else {
			mv.addObject("message","회원 탈퇴 실패");
			mv.addObject("path","./");
			mv.setViewName("common/messageMove");
		}
		
		return mv;
	}
}
