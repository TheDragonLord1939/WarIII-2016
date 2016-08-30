package com.dragon.warIII.core.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.dragon.warIII.core.dao.SuperDAO;
import com.dragon.warIII.core.springJdbc.SpringJdbcFactory;
import com.dragon.warIII.core.springMybatis.MyBatisFactory;

/**
 * @description 功能描述: SuperDAO统一接口定义实现类
 * @author 作 者: L.D
 * @date 建立日期：2016-6-26
 * @name 项目名称: warIII_core
 * @package 包及类名: com.dragon.warIII.dao.impl   SuperDAOImpl.java
 */
@Component("superDAO")
public class SuperDAOImpl implements SuperDAO{

	@Autowired 
	@Qualifier("springJdbcFactory")
	private SpringJdbcFactory springJdbcFactory;
	
	@Autowired
	@Qualifier("myBatisFactory")
	private MyBatisFactory myBatisFactory;
	
	
	@Override
	public SpringJdbcFactory getSpringJdbcFactory() {
		return springJdbcFactory;
	}

	@Override
	public MyBatisFactory getMyBatisFactory() {
		return myBatisFactory;
	}

}
