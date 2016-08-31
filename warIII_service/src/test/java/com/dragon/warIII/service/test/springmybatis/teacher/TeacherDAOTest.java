package com.dragon.warIII.service.test.springmybatis.teacher;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dragon.warIII.core.test.SuperTest;
import com.dragon.warIII.service.teacher.entity.Teacher;
import com.dragon.warIII.service.teacher.service.TeacherService;
@Ignore
public class TeacherDAOTest extends SuperTest{
	
	@Autowired
	private TeacherService teacherService;

	@Test
	public void testFindByNo() {
		Teacher teacher = teacherService.findByNo("t001");
		System.out.println(teacher);
	}
}
