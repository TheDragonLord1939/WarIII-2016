package com.dragon.warIII.unit04.case3.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *拦截器
 */
public class SomeInterceptor implements HandlerInterceptor{

	/*
	 *处理器执行前调用
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("preHandle start...");
		return true;
	}

	/* 
	 * 处理器执行后调用
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle start...");
		
	}

	/* 
	 * 请求处理完成后调用
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion start...");
		
	}

	
}
