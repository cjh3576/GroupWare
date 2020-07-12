package com.web.group.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
	
	@GetMapping("/api/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("/")
	public ModelAndView home() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	
}
