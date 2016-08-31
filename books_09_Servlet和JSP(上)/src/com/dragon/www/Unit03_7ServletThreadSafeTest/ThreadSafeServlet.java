package com.dragon.www.Unit03_7ServletThreadSafeTest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class ThreadSafeServlet extends HttpServlet {

	private int count = 0;

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
//		count++;
//		
//		try {
//			Thread.sleep(1000);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println(Thread.currentThread().getName() + ":" + count);
		
		synchronized (this) {
			count++;
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ":" + count);
		}
	}
}
