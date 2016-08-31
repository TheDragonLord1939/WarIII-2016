package com.dragon.warIII.unit04.case5.controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {

	@ExceptionHandler
	public String execute(HttpServletRequest req, Exception ex) {
		req.setAttribute("ex", ex);
		req.setAttribute("message", ex.getMessage());
		return "error";
	}
}
