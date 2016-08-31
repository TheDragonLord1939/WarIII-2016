package com.dragon.warIII.service.student.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dragon.warIII.service.student.dao.StudentDAO;
import com.dragon.warIII.service.student.entity.Student;
import com.dragon.warIII.service.student.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public int save(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String sNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Student findByNo(String sNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> findByNoToMap(String sNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findAll() {
		System.out.println("1111111111");
		return null;
	}

	@Override
	public List<Map<String, Object>> findAllToMap() {
		return studentDAO.findAllToMap();
	}

	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		return 0;
	}


	
}
