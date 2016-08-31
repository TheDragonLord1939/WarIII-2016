package com.dragon.warIII.unit04.case4.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/helloController")
public class HelloController2 {

	@RequestMapping(value="hello")
	public String doHello() {
		return "hello";
	}
}
