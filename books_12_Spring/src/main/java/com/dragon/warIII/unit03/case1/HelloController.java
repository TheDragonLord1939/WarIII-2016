package com.dragon.warIII.unit03.case1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("process hello.jhtml request.");
		ModelAndView mav = new ModelAndView("hello");
		return mav;
	}

	
}
