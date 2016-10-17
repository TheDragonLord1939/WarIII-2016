package com.dragon.war.boot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dragon.war.boot.entity.Demo;

@RestController
@RequestMapping("/demo")
public class DemoController {

	/**
	 * <p>测试JSON</p>
	 */
	@RequestMapping("/getDemo")
	public Demo getDemo() {
		
		Demo demo = new Demo();
		demo.setId(1);
		demo.setName("Angel Love Demon. It's real.");
		
		return demo;
	}
	
	/**
	 * <p>测试全局异常处理</p>
	 */
	@RequestMapping("/zeroException")
	public int zeroException() {
		return 100/0;
	}
}
