package com.dragon.warIII.json;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dragon.warIII.json.entity.Friend;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mvc.xml" })
@Ignore
public class JsonTest {

	/**
	 * @description 功能描述：Java对象转换为JSON字符串
	 */
	@Test
	public void toJsonObject() {
		
	}
}
