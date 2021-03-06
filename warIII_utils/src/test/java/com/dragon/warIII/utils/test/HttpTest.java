package com.dragon.warIII.utils.test;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.dragon.warIII.utils.http.HttpClient;

public class HttpTest {

	@Test
	public void test1() {
		try {
			String result = HttpClient.httpPostWithMap("http://commapi.228.cn/message/send", null);
			System.out.println("result-->" + result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("grant_type", "111");
		params.put("appid", "465b9482-a2aa-4fb9-920a-59e71abcc0ee");
		params.put("secret", "92ab88fb-321e-4897-b007-e68f5a75ce73");
		try {
			String result = HttpClient.httpGet("http://localhost:90/message/token", params, "");
			System.out.println("result=" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
