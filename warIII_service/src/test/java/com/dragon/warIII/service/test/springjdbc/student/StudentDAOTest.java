package com.dragon.warIII.service.test.springjdbc.student;

import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dragon.warIII.core.test.SuperTest;
import com.dragon.warIII.service.student.dao.StudentDAO;
import com.dragon.warIII.service.student.entity.Student;
import com.dragon.warIII.service.student.service.StudentService;

@Ignore
public class StudentDAOTest extends SuperTest{
	
	@Autowired
	StudentDAO studentDAO;
	
	@Autowired
	StudentService studentService;
	
	@Ignore
	@Test
	public void testSave() {
		Student student = new Student();
		student.setsNo("s011");
		student.setsName("张三丰");
		student.setsAge(99);
		student.setsSex("男");
		
		int num = studentDAO.save(student);
		System.out.println("num="+num);
	}
	
	@Ignore
	@Test
	public void testDelete() {
		int num = studentDAO.delete("s011");
		System.out.println("num="+num);
	}
	
	@Ignore
	@Test
	public void testUpdate() {
		Student student = new Student();
		student.setsNo("s011");
		student.setsName("张三丰");
		student.setsAge(99);
		student.setsSex("男");
		
		int num = studentDAO.update(student);
		System.out.println("num="+num);
	}
	
	@Ignore
	@Test
	public void testFindByNo() {
		Student student = studentDAO.findByNo("s001");
		System.out.println("student="+student);
	} 
	
	@Ignore
	@Test
	public void testFindByNoToMap() {
		Map<String,Object> studentMap = studentDAO.findByNoToMap("s005");
		System.out.println("studentMap="+studentMap);
	}
	
	@Ignore
	@Test
	public void testFindAll() {
		List<Student> list = studentDAO.findAll();
		System.out.println("list="+list);
	}
	
	@Ignore
	@Test
	public void testFindAllToMap() {
		List<Map<String, Object>> list = studentDAO.findAllToMap();
		System.out.println("listMap="+list);
	}
	
	@Ignore
	@Test
	public void findCount() {
		int num = studentDAO.findCount();
		System.out.println("num="+num);
	}
	
	@Ignore
	@Test
	public void testFindAllToMap2() {
		List<Map<String, Object>> list = studentService.findAllToMap();
		System.out.println("listMap="+list);
	}
}














