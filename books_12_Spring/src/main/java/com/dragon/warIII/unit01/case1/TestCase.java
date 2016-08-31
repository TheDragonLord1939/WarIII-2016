package com.dragon.warIII.unit01.case1;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:conf/applicationContext.xml" })
public class TestCase {

	/**测试实例化Spring容器*/
	@Test
	public void testInitContext() {  
		String conf = "conf/applicationContext.xml";
		ApplicationContext ac =  new ClassPathXmlApplicationContext(conf);
		System.out.println(ac);
		
		Calendar c = new GregorianCalendar();
		Calendar.getInstance();
		
		GregorianCalendar gc = new GregorianCalendar();
		gc.getTime();
	}
}
