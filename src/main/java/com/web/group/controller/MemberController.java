package com.web.group.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
}
