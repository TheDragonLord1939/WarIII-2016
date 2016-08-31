package com.dragon.www.unit01_1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	public void service(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//创建Cookie
		Cookie c1 = new Cookie("name", "yuelonghua");
		Cookie c2 = new Cookie("city", "Shenyang");
		//添加Cookie到response
		response.addCookie(c1);
		response.addCookie(c2);
		out.write("设置Cookie成功.");
		out.close();
	}

}
