package com.dragon.warIII.service.student.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dragon.warIII.core.dao.MyBatisRepository;
import com.dragon.warIII.service.student.entity.Student;

//@MyBatisRepository
public interface StudentDAO {

	public int save(Student student);
	
	public int delete(String sNo);
	
	public int update(Student student);
	
	public Student findByNo(String sNo);
	public Map<String, Object> findByNoToMap(String sNo);
	
	public List<Student> findAll();
	public List<Map<String, Object>> findAllToMap();
	
	public int findCount();
	
}
