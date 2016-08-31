package com.dragon.warIII.service.student.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;




/**
 * @description 功能描述: Stuent映射类
 * @author 作 者: L.D
 * @date 建立日期：2016-6-26
 * @name 项目名称: warIII_service
 * @package 包及类名: com.dragon.warIII.service.student.entity.student   StudentMapper.java
 */
public class StudentMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowIndex) throws SQLException {
		
		Student student = new Student();
		student.setsNo(rs.getString("SNO"));
		student.setsName(rs.getString("SNAME"));
		student.setsAge(rs.getInt("SAGE"));
		student.setsSex(rs.getString("SSEX"));
		
		return student;
	}

}
