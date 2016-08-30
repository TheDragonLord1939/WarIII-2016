package com.dragon.warIII.service.teacher.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.dragon.warIII.core.dao.SuperDAO;
import com.dragon.warIII.service.teacher.dao.TeacherDAO;
import com.dragon.warIII.service.teacher.entity.Teacher;

@Repository("teacherDAO")
public class TeacherDAOImpl implements TeacherDAO {

	private final static String NAME_SPACE = "com.dragon.warIII.service.teacher.dao.TeacherDAO.";
	
	@Autowired
	@Qualifier("superDAO")
	private SuperDAO superDAO;
	
	@Override
	public Teacher findByNo(String tNo) {
		return superDAO.getMyBatisFactory().getSqlSessionTemplate().selectOne(NAME_SPACE.concat("findByNo"), tNo);
	}

}
