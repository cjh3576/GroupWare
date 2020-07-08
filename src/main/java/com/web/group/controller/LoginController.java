package com.web.group.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.web.group.member.MemberService;
import com.web.group.member.MemberVO;

@Controller
@RequestMapping("/login/")
public class LoginController {
	@Autowired
	MemberService loginService;
	
	@RequestMapping(value = "memberList", method = RequestMethod.GET)
	public ModelAndView selectListMember() throws Exception{
		ModelAndView mv = new ModelAndView();
		List<MemberVO> list = memberService.selectListMember();
		
		mv.addObject("list",list);
		mv.setViewName("member/memberList");
		
		return mv;
	}
	
	//login
	@RequestMapping(value = "memberLogin", method = RequestMethod.GET)
	public void memberLogin() throws Exception{};
	
	@RequestMapping(value = "memberLogin", method =  RequestMethod.POST)
	public ModelAndView login(MemberVO memberVO,HttpSession session, ModelAndView mv ) throws Exception {
		MemberVO vo= memberService.login(memberVO);
		if(vo!=null) {
			mv.setViewName("redirect:../");
		} else {
			mv.addObject("message","로그인을 실패하였습니다.");
			mv.addObject("path","../member/memberLogin");
			mv.setViewName("common/messageMove");
		}
		return mv;
	}
	
	//logout
	public ModelAndView logout(HttpSession session, ModelAndView mv) throws Exception{
		session.invalidate();
		mv.setViewName("redirect:../");
		return mv;
	}
}
