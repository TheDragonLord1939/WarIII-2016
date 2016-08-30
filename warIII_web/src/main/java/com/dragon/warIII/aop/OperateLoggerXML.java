package com.dragon.warIII.aop;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @description 功能描述: 用于记录日志的方面组件,演示Spring AOP的各种通知类型  
 * @author 作 者: L.D
 * @date 建立日期：2016-7-10
 * @name 项目名称: warIII_web
 * @package 包及类名: com.dragon.warIII.aop   OperateLogger.java
 * @version 1.0
 * @copyright ©2016-2026 瀧腾科技股份有限公司. All Rights Reserved.
 */
public class OperateLoggerXML {

	/**
	 * <p>1.1.前置通知方法</p>  
	 */
	public void beforeLog() {
		//记录日志
		System.out.println("前置通知-->记录用户操作信息");
	}
	/**
	 * <p>1.2.后置通知方法</p>  
	 */
	public void afterReturnLog() {
		//记录日志
		System.out.println("后置通知-->记录用户操作信息");
	}
	/**
	 * <p>1.3.最终通知方法</p>  
	 */
	public void afterLog() {
		//记录日志
		System.out.println("最终通知-->记录用户操作信息");
	}
	
	/**
	 * <p>2.环绕通知方法</p>  
	 * @throws Throwable 
	 */
	public Object aroundLog(ProceedingJoinPoint p) throws Throwable {
		//1.目标组件的类名
		String className = p.getTarget().getClass().getName();
		//2.调用的方法名
		String method = p.getSignature().getName();
		//3.当前系统时间
		String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		//4.拼日志信息
		String msg = "环绕通知前置-->用户" + date + "执行了" + className + "." + method +"()";
		//5.记录日志
		System.out.println(msg);
		//6.执行密保组件方法
		Object obj = p.proceed();
		//7.在调用目标组件业务方法后也可以做一些业务处理
		System.out.println("环绕通知后置-->调用目标组件业务方法后...");
		
		return obj;
	}
	
	/**
	 * <p>3.异常通知使用方法</p>
	 * @param e  
	 */
	public void afterThrowingLog(Exception e) {
		StackTraceElement[] elems = e.getStackTrace();
		//将异常信息记录
		System.out.println("异常通知-->" + elems[0].toString());
	}
}
