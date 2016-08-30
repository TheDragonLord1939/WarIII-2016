package com.dragon.warIII.service.emp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.dragon.warIII.service.emp.dao.TEmpDAO;
import com.dragon.warIII.service.emp.entity.TEmp;
import com.dragon.warIII.service.emp.service.TEmpService;


public class TEmpServiceImpl implements TEmpService{

	@Autowired
	private TEmpDAO tEmpDAO;
	
	@Override
	public Integer save(TEmp tEmp) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
