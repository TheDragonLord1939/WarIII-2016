package com.dragon.warIII.core.log;

import org.apache.log4j.Logger;

/**
 * @description 功能描述: 日志工具类
 * @author 作 者: L.D
 * @date 建立日期：2016-6-26
 * @name 项目名称: warIII_utils
 * @package 包及类名: com.dragon.warIII.utils.log   LogRecord.java
 */
public final class LogRecord {
	
	/**
	 * <p>非错误日志</p>
	 * @param msg
	 * @param cls  
	 */
	public static void info(String msg,Class<?> cls) {
    	Logger.getLogger(cls).info(msg);
    }
	

	/**
	 * <p>非错误日志</p>
	 * @param e
	 * @param cls  
	 */
	public static void info(Throwable e,Class<?> cls) {
    	Logger.getLogger(cls).info(e.toString(),e);
    }

	
	/**
	 * <p>非错误日志</p>
	 * @param msg
	 * @param e
	 * @param cls  
	 */
	public static void info(String msg,Throwable e,Class<?> cls) {
    	Logger.getLogger(cls).info(msg, e);
    }
	
	/**
	 * <p>错误日志</p>
	 * @param msg
	 * @param cls  
	 */
	public static void error(String msg,Class<?> cls) {
    	Logger.getLogger(cls).error(msg);
    }
	

	/**
	 * <p>错误日志</p>
	 * @param e
	 * @param cls  
	 */
	public static void error(Throwable e,Class<?> cls) {
    	Logger.getLogger(cls).error(e.getMessage(),e);
    }
	

	/**
	 * <p>错误日志</p>
	 * @param msg
	 * @param e
	 * @param cls  
	 */
	public static void error(String msg,Throwable e,Class<?> cls) {
    	Logger.getLogger(cls).error(msg, e);
    }
}
