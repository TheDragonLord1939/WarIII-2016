package com.dragon.warIII.md5;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import org.apache.log4j.Logger;

/**
 * @description 功能描述: MD5工具类
 * @author 作 者: L.D
 * @createdate 建立日期：2016-8-31
 * @projectname 项目名称: Java_001_EncryptionAndDecryption
 * @packageclass 包及类名: com.dragon.warIII.md5  MD5Util.java
 */
public class MD5Util {

	private static final Logger logger = Logger.getLogger(MD5Util.class);
	/**
	 *<p>1.获取MD5,返回加密后的小写字符串</p>
	 * @throws Exception 
	 */
	public static String getMD5(String message) {
		String md5Str = null;
		try {
			//1.创建一个提供信息摘要算法的对象,初始化为md5算法对象
			MessageDigest md = MessageDigest.getInstance("MD5");
			//2.将消息变成byte数组
			byte[] input = message.getBytes(StandardCharsets.UTF_8);
			//3.计算后获得字节数组,那就是128位了 
			byte[] buff = md.digest(input);
			//4.把数组每一字节(一个字节占八位)换成16进制连成md5字符串
			md5Str = bytesToHex(buff);
		} catch (Exception e) {
			logger.error("get md5 error,cause by " + e.getMessage(), e);
			e.printStackTrace();
		}
		return md5Str;
	}
	
	/**
	 * <p>2.二进制转十六进制</p>
	 */
	public static String bytesToHex(byte[] bytes) {
		StringBuffer md5Str = new StringBuffer();
		//1.把数组每一字节换成16进制连成md5字符串
		int digital;
		for(int i = 0; i < bytes.length; i++) {
			digital = bytes[i];
			if (digital < 0) {
				digital += 256;
			}
			if (digital < 16) {
				md5Str.append("0");
			}
			md5Str.append(Integer.toHexString(digital));
		}
		return md5Str.toString();
	}
}










