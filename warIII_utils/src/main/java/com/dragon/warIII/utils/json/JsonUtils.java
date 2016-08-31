package com.dragon.warIII.utils.json;

import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import com.dragon.warIII.utils.string.StringUtils;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @description 功能描述: json转换工具类
 * @author 作 者: L.D
 * @date 建立日期：2016-6-26
 * @name 项目名称: warIII_utils
 * @package 包及类名: com.dragon.warIII.utils.json   JsonUtils.java
 * @version 1.0
 * @copyright ©2016-2026 瀧腾科技股份有限公司. All Rights Reserved.
 */
public class JsonUtils {
	
	private static ObjectMapper mapper = new ObjectMapper();

	/**
	 * <p>将Object对象转换成json字符串</p>
	 * @param obj
	 * @return
	 * @throws Exception  
	 */
	public static String format(Object obj) throws Exception {
		if(StringUtils.isBlank(obj)){
			return null;
		}
		if(mapper == null){
			mapper = new ObjectMapper();
		}
		try(
				StringWriter sw = new StringWriter();
				JsonGenerator gen = new JsonFactory().createGenerator(sw);
		  ){
			mapper.writeValue(gen, obj);
			return sw.toString();
		}catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * <p>将json字符串转换成Map</p>
	 * @param json
	 * @return
	 * @throws Exception  
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,Object> parseMap(String json) throws Exception {
		if(mapper == null){
			mapper = new ObjectMapper();
		}
		return (Map<String,Object>) mapper.readValue(json, Map.class); 
	}

	/**
	 * <p>将json字符串转换成List</p>
	 * @param json
	 * @return
	 * @throws Exception  
	 */
	@SuppressWarnings("unchecked")
	public static List<Map<String,Object>> parseList(String json) throws Exception {
		if(mapper == null){
			mapper = new ObjectMapper();
		}
		return (List<Map<String,Object>>) mapper.readValue(json, Map.class); 
	}
	
	public static Object parseObject(String json) throws Exception {
		if(StringUtils.isBlank(json)) {
			return null;
		}
		if(mapper == null){
			mapper = new ObjectMapper();
		}
		return mapper.readValue(json, Object.class);
	}
	
	public static void main(String[] args) throws Exception {
		Map map=parseMap("{message=success, code=200}");
		System.out.println("----" + map);
	}
}
