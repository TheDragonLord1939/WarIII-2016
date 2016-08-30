package com.dragon.warIII.service.teacher.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragon.warIII.service.teacher.dao.TeacherDAO;
import com.dragon.warIII.service.teacher.entity.Teacher;
import com.dragon.warIII.service.teacher.service.TeacherService;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherDAO teacherDAO;
	
	@Override
	public Teacher findByNo(String tNo) {
		return teacherDAO.findByNo(tNo);
	}

}
