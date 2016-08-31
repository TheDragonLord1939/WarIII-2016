package com.dragon.warIII.test.base64;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.junit.Ignore;
import org.junit.Test;

import com.dragon.warIII.base64.Base64Util;

public class Base64UtilTest {

	@Ignore
	@Test
	public void testEncode() {
		String str = "你好,我是瀧爷.";
		String enStr = Base64Util.encode(str.getBytes());
		System.out.println("加密后的字符串：" + enStr);//加密后的字符串：5L2g5aW9LOaIkeaYr+eAp+eIty4=
	}
	
	@Ignore
	@Test
	public void testDecode() {
		String enStr = "5L2g5aW9LOaIkeaYr+eAp+eIty4=";
		byte[] arr = Base64Util.decode(enStr.getBytes());
		String str = new String(arr);
		System.out.println("解密后的字符串：" + str);
	}
	
	@Test
	public void testUrlEncode() {
		String url = null;
		try {
			url = "http://wenwen.soso.com/z/q134386517.htm?url="+URLEncoder.encode("http://wenwen.soso.com/z/q134386517.htm", StandardCharsets.UTF_8.toString());
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("url: " + url);
	}
}
