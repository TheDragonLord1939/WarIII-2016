package com.dragon.warIII.service.course.dao;

import java.util.List;
import java.util.Map;

import com.dragon.warIII.service.course.entity.Course;

public interface CourseDAO {

	public int save(Course course);//1.1.保存实体
	//TODO                         //1.2.保存Map
	
	public int delete(String cNo);	//2.1.根据主键删除
	//TODO 							//2.2.根据Map删除 
	
	public int update(Course course);	//3.1.根据实体修改
	//TODO 								//3.2.根据Map修改
	
	public Course findByNo(String cNo);  //4.1.根据主键查找,返回一个实体
	//TODO 								 //4.2.根据Map查找,返回返回一个实体
	public Map<String, Object> findByNoToMap(String cNo); //4.3.根据主键查找,返回Map
	//TODO												  //4.4. 根据Map查找,返回Map
	
	public List<Course> findAll();			//5.1.查找所有记录,返回所有实体
	public List<Course> findAllByMap(Map<String, Object> params);	//5.2.根据Map查找,返回所有实体
	public List<Map<String, Object>> findAllToMap();	//5.3.查找所有记录,返回所有List<Map>
	//TODO												//5.4.根据Map查找所有记录,返回所有List<Map>
	
	public int findCount();		//6.1. 查找所有的记录总数
	//TODO 						//6.2. 根据Map查找对应的记录总数

	public List<Course> findByNos(List<String> nos);
}
