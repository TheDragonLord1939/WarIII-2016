package com.dragon.warIII.service.emp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.dragon.warIII.core.dao.SuperDAO;
import com.dragon.warIII.service.emp.dao.TEmpDAO;
import com.dragon.warIII.service.emp.entity.TEmp;

@Repository
public class TEmpDAOImpl implements TEmpDAO {

	private final static String NAME_SPACE = "com.dragon.warIII.service.emp.dao.TEmpDAO.";

	@Autowired
	@Qualifier("superDAO")
	private SuperDAO superDAO;
	
	@Override
	public Integer save(TEmp tEmp) {
		return superDAO.getMyBatisFactory().getSqlSessionTemplate().insert(NAME_SPACE.concat("save"), tEmp);
	}

}
