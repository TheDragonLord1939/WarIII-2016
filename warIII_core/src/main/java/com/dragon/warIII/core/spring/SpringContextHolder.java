package com.dragon.warIII.core.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.dragon.warIII.core.log.AsyncLogRecord;


/**
 * @description 功能描述:获取Spring Bean的通用方法，任意位置都能获取到
 * @author 作 者: L.D
 * @date 建立日期：2016-6-26
 * @name 项目名称: warIII_core
 * @package 包及类名: com.dragon.warIII.core.spring   SpringContextHolder.java
 * @version 1.0
 * @copyright ©2016-2026 瀧腾科技股份有限公司. All Rights Reserved.
 */
public class SpringContextHolder implements ApplicationContextAware {
	
	public static ApplicationContext applicationContext = null;
	
	/**
	 * <p>通过beanName获取spring管理的bean</p>
	 * @param name
	 * @return  
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		checkApplicationContext();
		return (T) applicationContext.getBean(name);
	}
	
	/**
	 * <p>根据class获取spring管理的bean</p>
	 * @param clazz
	 * @return  
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> clazz) {
		checkApplicationContext();
		return (T) applicationContext.getBeansOfType(clazz);
	}

	/**
	 * <p>检验ApplicationContext是否成功注入</p>  
	 */
	private static void checkApplicationContext() {
		if (applicationContext == null) {
			//AsyncLogRecord.getInstance().error("applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder",SpringContextHolder.class);
			throw new IllegalStateException(
					"applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder");
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		SpringContextHolder.applicationContext = applicationContext;
		AsyncLogRecord.getInstance().info("applicationContext初始化", this.getClass());
	}
}
