package com.dragon.warIII.service.course.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.dragon.warIII.core.dao.SuperDAO;
import com.dragon.warIII.service.course.dao.CourseDAO;
import com.dragon.warIII.service.course.entity.Course;

@Repository("courseDAO")
public class CourseDAOImpl implements CourseDAO{
	
	private final static String NAME_SPACE = "com.dragon.warIII.service.course.dao.CourseDAO.";

	@Autowired
	@Qualifier("superDAO")
	private SuperDAO superDAO;
	
	@Override
	public int save(Course course) {
		int num = superDAO.getMyBatisFactory().getSqlSessionTemplate().insert(NAME_SPACE.concat("save"), course);
		return num;
	}

	@Override
	public int delete(String cNo) {
		int num = superDAO.getMyBatisFactory().getSqlSessionTemplate().delete(NAME_SPACE.concat("delete"), cNo);
		return num;
	}

	@Override
	public int update(Course course) {
		int num = superDAO.getMyBatisFactory().getSqlSessionTemplate().update(NAME_SPACE.concat("update"), course);
		return num;
	}

	@Override
	public Course findByNo(String cNo) {
		Course course = superDAO.getMyBatisFactory().getSqlSessionTemplate().selectOne(NAME_SPACE.concat("findByNo"), cNo);
		return course;
	}

	@Override
	public Map<String, Object> findByNoToMap(String cNo) {
		Map<String, Object> map = superDAO.getMyBatisFactory().getSqlSessionTemplate().selectOne(NAME_SPACE.concat("findByNoToMap"), cNo);
		return map;
	}

	@Override
	public List<Course> findAll() {
		List<Course> list = superDAO.getMyBatisFactory().getSqlSessionTemplate().selectList(NAME_SPACE.concat("findAll"));
		return list;
	}
	
	@Override
	public List<Course> findAllByMap(Map<String, Object> params) {
		return superDAO.getMyBatisFactory().getSqlSessionTemplate().selectList(NAME_SPACE.concat("findAllByMap"), params);
	}

	@Override
	public List<Map<String, Object>> findAllToMap() {
		List<Map<String, Object>> list = superDAO.getMyBatisFactory().getSqlSessionTemplate().selectList(NAME_SPACE.concat("findAll"));
		return list;
	}

	@Override
	public int findCount() {
		int count = superDAO.getMyBatisFactory().getSqlSessionTemplate().selectOne(NAME_SPACE.concat("findCount"));
		return count;
	}

	@Override
	public List<Course> findByNos(List<String> nos) {
		return superDAO.getMyBatisFactory().getSqlSessionTemplate().selectList(NAME_SPACE.concat("findByNos"), nos);
	}

}
