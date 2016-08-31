package com.dragon.warIII.utils.string;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @description 功能描述: String工具类
 * @author 作 者: L.D
 * @date 建立日期：2016-6-26
 * @name 项目名称: warIII_utils
 * @package 包及类名: com.dragon.warIII.utils.string   StringUtils.java
 * @version 1.0
 * @copyright ©2016-2026 瀧腾科技股份有限公司. All Rights Reserved.
 */
public class StringUtils extends org.apache.commons.lang.StringUtils{
	
	private static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");
	
	/**
	 * <p>验证Collection是否为空</p>
	 * @param coll
	 * @return  
	 */
	public static boolean isEmpty(Collection<?> coll){
		return coll == null || coll.size() <= 0;
	}

	/**
	 * <p>验证Collection是否不为空</p>
	 * @param coll
	 * @return  
	 */
	public static boolean isNotEmpty(Collection<?> coll) {
		return !isEmpty(coll);
	}
	
	/**
	 * <p>验证Map是否为空</p>
	 * @param map
	 * @return  
	 */
	public static boolean isEmpty(Map<?,?> map){
		return map == null || map.size() <= 0;
	}
	
	/**
	 * <p>验证Map是否不为空</p>
	 * @param map
	 * @return  
	 */
	public static boolean isNotEmpty(Map<?,?> map) {
		return !isEmpty(map);
	}
	
	/**
	 * <p>验证Object是否为空</p>
	 * @param obj
	 * @return  
	 */
	public static boolean isBlank(Object obj) {
		return obj == null || isBlank(obj.toString());
	}
	
	/**
	 * <p>验证String是否为空</p>
	 * @param str
	 * @return  
	 */
	public static boolean isBlank(String str) {
		return str == null || StringUtils.isBlank(str);
	}
	
//	private static final String COUNT_SQL_REG = "select\\s+.*\\s+from\\s"; 
	private static final String COUNT_SQL_REG = "^\\s*?(select\\s+([\\s\\S]*?)\\s+)?from\\s+[\\s\\S]*?(\\sorder\\s[\\s\\S]*)?";
	private static final String COUNT_REPLACE = "select count(1) from ";

	/**
	 * <p>根据原始SQL获取countSQl</p>
	 * @param querySql
	 * @return  
	 */
	public static String getCountSql(String querySql) {
		return querySql.toLowerCase().replaceAll(COUNT_SQL_REG, COUNT_REPLACE).replace("\t\n", " ");
	}

	/**
	 * <p>根据原始SQL获取countSQL，不截取</p>
	 * @param querySql
	 * @return  
	 */
	public static String getCountSqlChild(String querySql) {
		return COUNT_REPLACE.concat("(").concat(querySql).concat(") t");
	}
	
	/**
	 * <p>获取UUID</p>
	 * @return  
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 用指定表达式格式化字符串
	 * 
	 * @param str 要格式化的字符串
	 * @param rgx 替换表达式
	 * @param args 要填充的参数
	 * @return
	 */
	/*public static String format(String str,String rgx,String ...args) {
		if(isBlank(args) || isBlank(str) || args.length <= 0) {return str;}
		for(String s : args) {
			str = str.replaceFirst(rgx, s);
		}
		return str;
	}*/
	
	/**
	 * <p>用指定表达式格式化字符串</p>
	 * @param str 要格式化的字符串
	 * @param rgx 替换表达式
	 * @param args 要填充的参数
	 * @return
	 */
	public static String format(String str,String rgx,Object ...args) {
		if(isBlank(args) || isBlank(str) || args.length <= 0) {return str;}
		for(Object s : args) {
			if(s != null){
				str = str.replaceFirst(rgx, s.toString());
			}
		}
		return str;
	}
	
	/**
	 * <p>生成sql占位符 ?,?,?</p>
	 * @param size
	 * @return  
	 */
	public static String sqlPlaceHolder(Integer size) {
		if (null == size || size < 1) {
			return "";
		} else {
			String[] paras = new String[size];
			Arrays.fill(paras, "?"); // L.cm 使用Arrays.fill替代for 2014.5.4
			return StringUtils.join(paras, ",");
		}
	}
	
	/**
	 * <p>计算表达式的值</p>
	 * @param str
	 * @param def
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T>T expEval(String str,T ...def) {
		try {
			Object obj = jse.eval(str);
			if(!StringUtils.isBlank(obj)) {
				return (T)obj;
			}
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		if(def != null && def.length > 0) {
			return def[0];
		}
		return null;
	}
	
	/**
	 * <p>根据全路径获取文件名称</p>
	 * @param allPath
	 * @return  
	 */
	public static String getFileName(Object allPath){
		String _path = StringUtils.isBlank(allPath)?"":allPath.toString();
		return _path.lastIndexOf("/")==-1?_path:_path.substring(_path.lastIndexOf("/")+1,_path.length());
	}
	
}
