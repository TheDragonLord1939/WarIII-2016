package com.dragon.warIII.utils.log;

import org.apache.log4j.Logger;

/**
 * 日志工具类
 * 
 * @author July july_sky@foxmail.com
 * @date 2015年4月3日下午2:38:27
 * @Copyright ©2016-2046 瀧腾科技. All Rights Reserved.
 * @version 1.0
 */
public final class LogRecord {
	/**
	 * 非错误日志
	 * 
	 * @author July july_sky@foxmail.com
	 * @date 2015年4月3日下午2:38:45
	 * @param msg
	 * @param cls
	 */
	public static void info(String msg,Class<?> cls) {
    	Logger.getLogger(cls).info(msg);
    }
	/**
	 * 非错误日志
	 * 
	 * @author July july_sky@foxmail.com
	 * @date 2015年4月3日下午2:39:16
	 * @param e
	 * @param cls
	 */
	public static void info(Throwable e,Class<?> cls) {
    	Logger.getLogger(cls).info(e.toString(),e);
    }
	/**
	 * 非错误日志
	 * 
	 * @author July july_sky@foxmail.com
	 * @date 2015年4月3日下午2:39:21
	 * @param msg
	 * @param e
	 * @param cls
	 */
	public static void info(String msg,Throwable e,Class<?> cls) {
    	Logger.getLogger(cls).info(msg, e);
    }
	
	/**
	 * 错误日志
	 * 
	 * @author July july_sky@foxmail.com
	 * @date 2015年4月3日下午2:39:25
	 * @param msg
	 * @param cls
	 */
	public static void error(String msg,Class<?> cls) {
    	Logger.getLogger(cls).error(msg);
    }
	
	/**
	 * 错误日志
	 * 
	 * @author July july_sky@foxmail.com
	 * @date 2015年4月3日下午2:39:34
	 * @param e
	 * @param cls
	 */
	public static void error(Throwable e,Class<?> cls) {
    	Logger.getLogger(cls).error(e.getMessage(),e);
    }
	
	/**
	 * 错误日志
	 * 
	 * @author July july_sky@foxmail.com
	 * @date 2015年4月3日下午2:39:39
	 * @param msg
	 * @param e
	 * @param cls
	 */
	public static void error(String msg,Throwable e,Class<?> cls) {
    	Logger.getLogger(cls).error(msg, e);
    }
}
