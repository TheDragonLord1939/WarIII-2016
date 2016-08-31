package com.dragon.warIII.unit04.case4.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {

	@RequestMapping("login")
	public String login(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute("user", "yuelonghua_user");
		return "login";
	}
}
