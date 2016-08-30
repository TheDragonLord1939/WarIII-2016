package com.dragon.warIII.unit04.case5.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dragon.warIII.unit04.case5.controller.exception.BaseController;

@Controller
@RequestMapping("hello3")
public class HelloContrller {

	@RequestMapping("hello")
	public void doAction(HttpServletRequest req) {
		
			try {
				String s = null;
				s.length();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
	}
}
