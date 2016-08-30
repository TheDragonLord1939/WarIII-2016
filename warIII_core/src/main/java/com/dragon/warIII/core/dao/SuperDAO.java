package com.dragon.warIII.core.dao;

import com.dragon.warIII.core.springJdbc.SpringJdbcFactory;
import com.dragon.warIII.core.springMybatis.MyBatisFactory;

/**
 * @description 功能描述: SuperDAO统一接口定义
 * @author 作 者: L.D
 * @date 建立日期：2016-6-26
 * @name 项目名称: warIII_core
 * @package 包及类名: com.dragon.warIII.dao   SuperDAO.java
 */
public interface SuperDAO {
	
	/**
	 * <p>1.SpringJdbc工具类</p>
	 * @return  
	 */
	public SpringJdbcFactory getSpringJdbcFactory();
	
	/**
	 * <p>2.SpringMybatis工具类</p>
	 * @return  
	 */
	public MyBatisFactory getMyBatisFactory();
}
