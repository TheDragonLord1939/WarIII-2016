package com.dragon.warIII.redis;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dragon.warIII.controller.student.StudentController;
import com.dragon.warIII.utils.redis.JedisUtil;

import redis.clients.jedis.Jedis;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-springMVC.xml" })
@Ignore
public class JedisTest {

	/**
	 * @description 功能描述：测试连接
	 */
	@Test
	public void ConnTest() {
		Jedis jedis = JedisUtil.createJedis("192.168.1.40", 6279,"406128445ncl");
		jedis.set("city", "shenyang");
		System.out.println(jedis.get("city"));
		if(jedis != null) {
			jedis.close();
		}
	}  
	
	
}
