package com.dragon.warIII.service.test.springmybatis.course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dragon.warIII.core.test.SuperTest;
import com.dragon.warIII.service.course.dao.CourseDAO;
import com.dragon.warIII.service.course.entity.Course;
import com.dragon.warIII.service.course.service.CourseService;

/**
 * @description 功能描述: 测试SqlSessionTemplate形式访问数据库
 * @author 作 者: L.D
 * @date 建立日期：2016-7-5
 * @name 项目名称: warIII_service
 * @package 包及类名: com.dragon.warIII.service.test.springmybatis.student   StudentDAOTest2.java
 * @version 1.0
 * @copyright ©2016-2026 瀧腾科技股份有限公司. All Rights Reserved.
 */
@Ignore
public class CourseDAOTest extends SuperTest{
	
	@Autowired
	CourseDAO courseDAO;
	
	@Autowired
	CourseService courseService;
	
	@Ignore
	@Test
	public void testSave() {
		Course c = new Course();
		c.setcNo("c011");
		c.setcName("Python");
		c.settNo("t003");
		
		int num = courseDAO.save(c);
		System.out.println("num="+num);
	}
	
	@Ignore
	@Test
	public void testDelete() {
		int num = courseDAO.delete("c011");
		System.out.println("num="+num);
	}
	
	@Ignore
	@Test
	public void testUpdate() {
		Course c = new Course();
		c.setcNo("c011");
		c.setcName("Python2077");
		c.settNo("t003");
		
		int num = courseDAO.update(c);
		System.out.println("num="+num);
	}
	
	@Ignore
	@Test
	public void testFindByNo() {
		Course course = courseDAO.findByNo("c001");
		System.out.println("course="+course);
	} 
	
	@Ignore
	@Test
	public void testFindByNoToMap() {
		Map<String,Object> map = courseDAO.findByNoToMap("c005");
		System.out.println("map="+map);
	}
	
	@Ignore
	@Test
	public void testFindAll() {
		List<Course> list = courseService.findAll();
		System.out.println("list="+list);
	}
	
	
	@Test
	public void testFindAllByMap() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("cname", "Oracle");
		List<Course> list = courseService.findAllByMap(params);
		System.out.println("list="+list);
	}
	
	@Ignore
	@Test
	public void testFindAllToMap() {
		List<Map<String, Object>> list = courseDAO.findAllToMap();
		System.out.println("listMap="+list);
	}
	
	@Ignore
	@Test
	public void findCount() {
		int num = courseDAO.findCount();
		System.out.println("num="+num);
	}
	
	@Ignore
	@Test
	public void testfindByNos() {
		List<String> list = new ArrayList<String>();
		list.add("c001");
		list.add("c002");
		List<Course> cs = courseDAO.findByNos(list);
		System.out.println(cs);
		
	}
}














