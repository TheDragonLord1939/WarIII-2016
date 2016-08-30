package com.dragon.warIII.unit04.case3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spring")
public class HelloController {
	
	@RequestMapping("/hello.jhtml")
	public String execute() {
		System.out.println("执行HelloController");
		return "hello";
	}
}
