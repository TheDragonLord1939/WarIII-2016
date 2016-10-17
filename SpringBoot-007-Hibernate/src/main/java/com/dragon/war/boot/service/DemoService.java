package com.dragon.war.boot.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dragon.war.boot.dao.DemoRepository;
import com.dragon.war.boot.entity.Demo;

@Service
public class DemoService {

	@Resource
	private DemoRepository demoRepository;
	
	@Transactional
	public void save(Demo demo) {
		demoRepository.save(demo);
	}
	
}
