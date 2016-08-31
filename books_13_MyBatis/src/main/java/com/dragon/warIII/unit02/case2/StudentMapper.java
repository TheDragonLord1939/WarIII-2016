package com.dragon.warIII.unit02.case2;

import java.util.List;
import java.util.Map;

import com.dragon.warIII.unit02.case2.entity.Student;

public interface StudentMapper {

//	public int save(Student student);
//	
//	public int delete(String sNo);
//	
//	public int update(Student student);
//	
//	public Student findByNo(String sNo);
//	public Map<String, Object> findByNoToMap(String sNo);
	
	public List<Student> findAll();
//	public List<Map<String, Object>> findAllToMap();
//	
//	public int findCount();
}
