package com.dragon.www.unit03_1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CommentFilter implements Filter{

	private String illegalWord;

	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		illegalWord = filterConfig.getInitParameter("illegalWord");
		System.out.println("init is running ...."+illegalWord);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String comment = request.getParameter("comment");
		if (comment.indexOf(illegalWord) != -1) {
			out.print("comment close");
		} else {
			chain.doFilter(request, response);
		}
		
		System.out.println("fukkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
		
	}

	@Override
	public void destroy() {
		System.out.println("end 22222222222222222222222");
		
	}

}
