package com.web.group.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.group.workmanage.WorkManageService;

@Controller
@RequestMapping("/work/")
public class WorkManageController {
	@Autowired
	WorkManageService workManageService;
	
	
	@GetMapping(value = "workManage")
	public ModelAndView selectList() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("work/workManage");
		
		return mv;
	}
}
