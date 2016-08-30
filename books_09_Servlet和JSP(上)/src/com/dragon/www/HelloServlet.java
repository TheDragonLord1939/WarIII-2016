package com.dragon.www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	private int num = 1;
	
	public HelloServlet() {
		System.out.println("阶段1.实例化");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("阶段2.初始化");
	}
	
	public void service(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
//		response.sendRedirect("http://www.baidu.com");
		out.print("<h1>Hello Servlet,你好</h1>");
		System.out.println();
		out.close();
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("阶段4.销毁");
	}

}
