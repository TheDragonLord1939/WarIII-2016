package com.dragon.warIII.core.log;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


import com.dragon.warIII.core.spring.SpringContextHolder;
import com.dragon.warIII.utils.json.JsonUtils;
import com.dragon.warIII.utils.string.StringUtils;

@Component("asyncLogRecord")
public class AsyncLogRecord {
	private static AsyncLogRecord asyncLogRecord;
	/**
	 * 调试异常信息
	 * 
	 * @param message
	 *            异常信息
	 * 
	 * @param clazz
	 */
	@Async
	public void debug(String message, Class<?> clazz) {
		try {
			LoggerFactory.getLogger(clazz).debug(message);
		} catch (Exception e) {
		}
	}

	/**
	 * 调试异常信息
	 * 
	 * @param message
	 * @param t
	 * @param clazz
	 */
	@Async
	public void debug(String message, Throwable t, Class<?> clazz) {
		LoggerFactory.getLogger(clazz).debug(message, t);
	}

	/**
	 * 一般异常信息
	 * 
	 * @param message
	 *            异常信息
	 * 
	 * @param clazz
	 */
	@Async
	public void info(Object message, Class<?> clazz) {
		LoggerFactory.getLogger(clazz).info(StringUtils.isBlank(message)?"":message.toString());
	}

	/**
	 * 一般异常信息
	 * 
	 * @param message
	 * @param t
	 * @param clazz
	 */
	@Async
	public void info(String message, Throwable t, Class<?> clazz) {
		LoggerFactory.getLogger(clazz).info(message, t);
	}

	/**
	 * 错误信息
	 * 
	 * @param message
	 *            错误信息
	 * 
	 * @param clazz
	 */
	@Async
	public void error(Throwable t, Class<?> clazz) {
		LoggerFactory.getLogger(clazz).info(t.getMessage(), t);
	}

	/**
	 * 错误信息
	 * 
	 * @param message
	 * @param t
	 * @param clazz
	 */
	@Async
	public void error(String message, Throwable t, Class<?> clazz) {
		LoggerFactory.getLogger(clazz).error(message, t);
	}
	/**
	 * 日志输出，将obj转换成json字符串
	 * @param message
	 * @param obj
	 * @param clazz
	 */
	@Async
	public void info(String message, Object obj,Class<?> clazz) {
		try {
			this.info(message.concat(JsonUtils.format(obj)),clazz);
		} catch (Exception e) {
			this.error("日志json转换异常",e, clazz);
		}
	}
	
	/**
	 * 获得日志对象
	 * 
	 * @return
	 */
	public static AsyncLogRecord getInstance(){
		if(asyncLogRecord != null){
			return asyncLogRecord;
		}
		return SpringContextHolder.getBean("asyncLogRecord");
	}

	@Async
	public void error(String message, Class<?> clazz) {
		LoggerFactory.getLogger(clazz).error(message);
	}
}
