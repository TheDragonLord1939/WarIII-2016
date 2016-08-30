package com.dragon.warIII.service.student.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.dragon.warIII.core.dao.SuperDAO;
import com.dragon.warIII.service.student.dao.StudentDAO;
import com.dragon.warIII.service.student.entity.Student;
import com.dragon.warIII.service.student.entity.StudentMapper;

@Repository("studentDAO")
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	@Qualifier("superDAO")
	private SuperDAO superDAO;

	@Override
	public int save(Student student) {
		String sql = "insert into student (sno, sname, sage, ssex) "
				+ "values (?,?,?,?)";
		Object[] params = { student.getsNo(), student.getsName(),
				student.getsAge(), student.getsSex() };
		int num = superDAO.getSpringJdbcFactory().getJdbcTemplate().update(sql, params);
		return num;
	}

	@Override
	public int delete(String sNo) {
		String sql = "delete from student where sno = ?";
		Object[] params = {sNo};
		int num = superDAO.getSpringJdbcFactory().getJdbcTemplate().update(sql, params);
		return num;
	}

	@Override
	public int update(Student student) {
		String sql = "update student set sname=?, sage=?, ssex=? where sno = ?";
		Object[] params = {student.getsName(),student.getsAge(),
				student.getsSex(),student.getsNo()};
		int num = superDAO.getSpringJdbcFactory().getJdbcTemplate().update(sql, params);
		return num;
	}

	@Override
	public Student findByNo(String sNo) {
		String sql = "select * from student where sno = ?";
		Object[] params = {sNo};
		RowMapper<Student> mapper = new StudentMapper();
		Student student = superDAO.getSpringJdbcFactory().getJdbcTemplate()
				.queryForObject(sql, params, mapper);
		return student;
	}

	@Override
	public Map<String, Object> findByNoToMap(String sNo) {
		String sql = "select * from student where sno = ?";
		Object[] params = {sNo};
		Map<String, Object> map = superDAO.getSpringJdbcFactory().getJdbcTemplate().queryForMap(sql, params);
		return map;
	}

	@Override
	public List<Student> findAll() {
		String sql = "select * from student";
		RowMapper<Student> mapper = new StudentMapper();
		List<Student> list = superDAO.getSpringJdbcFactory().getJdbcTemplate()
				.query(sql, mapper);
		return list;
	}
	
	@Override
	public List<Map<String, Object>> findAllToMap() {
		String sql = "select * from student";
		List<Map<String, Object>> list = superDAO.getSpringJdbcFactory().getJdbcTemplate().queryForList(sql);
		return list;
	}

	@Override
	public int findCount() {
		String sql = "select count(*) from student";
		int count = superDAO.getSpringJdbcFactory().getJdbcTemplate().queryForObject(sql, Integer.class);
		return count;
	}

	
	
}
