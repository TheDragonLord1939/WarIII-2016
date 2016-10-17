package com.dragon.warIII.utils.entity;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.dragon.warIII.utils.log.LogRecord;

public class BaseEntity implements Serializable {

	private static final long serialVersionUID = -1268180140730752287L;

	/**
	 * 获取Bean的所有属性值
	 * 
	 * @author July july_sky@foxmail.com
	 * @date 2015年5月4日上午10:17:49
	 * @param o
	 * @param c
	 * @return
	 */
	public static Map<String,Object> getFields(Object obj) {
		if(obj == null){
			return null;
		}
		Map<String,Object> map = new HashMap<>();
		Class<?> cls = obj.getClass();

		// 获取类中的所有定义字段
		Field[] fields = cls.getDeclaredFields();
		Object objs = null;
		// 循环遍历字段，获取字段对应的属性值
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				objs = field.get(obj);
				map.put(field.getName(), objs == null?"":objs);
			} catch (Exception e) {
				LogRecord.error("属性[".concat(field.getName()).concat("]不存在get方法:"),e, cls);
			}
		}
		return map;
	}
	
	/**
	 * 获取Bean的所有属性值
	 * 
	 * @author July july_sky@foxmail.com
	 * @date 2015年5月4日上午10:17:49
	 * @param o
	 * @param c
	 * @return
	 */
	public static ModelAndView getFields(Object obj,ModelAndView mv) {
		if(obj == null){
			return null;
		}
		mv = mv == null ?new ModelAndView():mv;
		Class<?> cls = obj.getClass();

		// 获取类中的所有定义字段
		Field[] fields = cls.getDeclaredFields();
		Object objs = null;
		// 循环遍历字段，获取字段对应的属性值
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				objs = field.get(obj);
				mv.addObject(field.getName(), objs == null?"":objs);
			} catch (Exception e) {
				LogRecord.error("属性[".concat(field.getName()).concat("]不存在get方法:"),e, cls);
			}
		}
		return mv;
	}
}
