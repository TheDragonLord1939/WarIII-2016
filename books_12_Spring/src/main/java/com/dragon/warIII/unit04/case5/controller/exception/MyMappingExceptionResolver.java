//package com.dragon.warIII.unit04.case5.controller.exception;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerExceptionResolver;
//import org.springframework.web.servlet.ModelAndView;
//
//@Component
//public class MyMappingExceptionResolver implements HandlerExceptionResolver{
//
//	@Override
//	public ModelAndView resolveException(HttpServletRequest request,
//			HttpServletResponse response, Object handler, Exception ex) {
//		Map<String, Object> model = new HashMap<String, Object>();
//		
//		return new ModelAndView("error", model);
//	}
//
//	
//}
