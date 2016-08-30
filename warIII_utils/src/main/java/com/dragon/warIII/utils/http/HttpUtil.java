package com.dragon.warIII.utils.http;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @description 功能描述: HttpClient辅助工具
 * @author 作 者: L.D
 * @createdate 建立日期：2016-8-26
 * @projectname 项目名称: warIII_utils
 * @packageclass 包及类名: com.dragon.warIII.utils.http  HttpUtil.java
 */
public class HttpUtil {

	/**
	 *<p>1.将输入流内信息转换成字符串</p>
	 */
	public static final String inputStream2String(InputStream in) throws IOException {
		if (in == null) 
			throw new RuntimeException("inputStream is null.");
		StringBuffer out = new StringBuffer();
		byte[] b = new byte[4096];
		for (int n; (n = in.read(b)) != -1;) {
			out.append(new String(b, 0, n, StandardCharsets.UTF_8));
		}
		
		return out.toString();
	}
}
