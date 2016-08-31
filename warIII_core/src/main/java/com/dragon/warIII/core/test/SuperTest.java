package com.dragon.warIII.core.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
		"classpath:conf/applicationContext-springJdbc.xml", 
		"classpath:conf/applicationContext-springMyBatis.xml"})
public class SuperTest {

}
