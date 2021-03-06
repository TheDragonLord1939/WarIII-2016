package com.dragon.warIII;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dragon.warIII.product.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)	//Junit4里它用来做Junit加载器
@ContextConfiguration(locations={"classpath:conf/ApplicationContext.xml"})	//主要用来加载spring的配置文件路径：是一个字符串数组，可以加载多个Spring配置文件
public class Log4jTest {

	@Autowired
	ProductService productService;
	
	@Test
	public void test1() {
		productService.save();
	}
}
