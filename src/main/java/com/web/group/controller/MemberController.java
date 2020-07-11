package com.web.group.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	@RequestMapping(value = "memberList", method = RequestMethod.GET)
	public ModelAndView selectListMember() throws Exception{
		ModelAndView mv = new ModelAndView();
		List<MemberVO> list = memberService.selectListMember();

		mv.addObject("list",list);
		mv.setViewName("member/memberList");

		return mv;
	}
	//security login
	@RequestMapping(value="login", method = RequestMethod.GET)
	public ModelAndView login() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/login");
		return mv;
	}

	//logout
	public ModelAndView logout(HttpSession session, ModelAndView mv) throws Exception{
		session.invalidate(); //무효화
		mv.setViewName("redirect:../");
		return mv;
	}


	//my page
	@RequestMapping(value = "MyPage",method = RequestMethod.GET)
	public ModelAndView myPage(ModelAndView mv, HttpSession session,Principal principal) throws Exception{
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
}
