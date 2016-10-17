package com.dragon.war.boot.web;

import java.util.Random;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dragon.war.boot.entity.Demo;
import com.dragon.war.boot.service.DemoService;

@RestController
@RequestMapping("/demo")
public class DemoController {

	@Resource
	private DemoService demoService;
	
	@RequestMapping("/save")
	public String save() {
		for(int i=1; i<=1000; i++) {
			Demo d = new Demo();
			d.setId(i);
			d.setName("Ange" + Math.random());
			demoService.save(d);
		}
		return "ok.DemoController.save";
	}
	
}
