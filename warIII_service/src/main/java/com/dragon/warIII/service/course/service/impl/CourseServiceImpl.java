package com.dragon.warIII.service.course.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.dragon.warIII.service.course.dao.CourseDAO;
import com.dragon.warIII.service.course.entity.Course;
import com.dragon.warIII.service.course.service.CourseService;

@Service("courseService")
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDAO courseDAO;

	@Override
	public int save(Course course) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String cNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Course course) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Course findByNo(String cNo) {
		return courseDAO.findByNo(cNo);
	}

	@Override
	public Map<String, Object> findByNoToMap(String cNo) {
		return courseDAO.findByNoToMap(cNo);
	}

	@Cacheable(key = "#root.targetClass.name+'.'+#root.methodName", value = "ssmcache", cacheManager = "ssmCacheManager")
	@Override
	public List<Course> findAll() {
		System.out.println("访问数据库,未使用缓存.");
		return courseDAO.findAll();
	}
	
	@Cacheable(key = "#root.targetClass.name+'.'+#root.methodName+'.'+#params.get('cname')", value = "ssmcache", cacheManager = "ssmCacheManager")
	@Override
	public List<Course> findAllByMap(Map<String, Object> params) {
		System.out.println("访问数据库，未使用缓存.");
		return courseDAO.findAllByMap(params);
	}

	@Override
	public List<Map<String, Object>> findAllToMap() {
		return courseDAO.findAllToMap();
	}

	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
