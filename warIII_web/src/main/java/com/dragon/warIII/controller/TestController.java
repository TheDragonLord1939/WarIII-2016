package com.dragon.warIII.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class TestController extends BaseController{

	@RequestMapping("/showUserInfo")
	public String showUserInfo(HttpServletRequest request, Model model){
		
		String str = "hello world";
		model.addAttribute("str", str);
		
		return "showUser";
	}
	
}
