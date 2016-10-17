package com.dragon.war.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController				//@RestController返回json字符串的数据,直接可以编写RESTFul的接口.
//@SpringBootApplication		//其中@SpringBootApplication申明让spring boot自动给程序进行必要的配置,等价于以默认属性使用@Configuration,@EnableAutoConfiguration和@ComponentScan.
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class App {

//	@RequestMapping("/")
//	public String hello() {
//		return "Hello World!";
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
