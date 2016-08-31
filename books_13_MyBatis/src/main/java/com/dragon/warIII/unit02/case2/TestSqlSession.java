package com.dragon.warIII.unit02.case2;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dragon.warIII.unit02.case2.entity.Student;

public class TestSqlSession {

	
	public static void main(String[] args) throws IOException {
		String conf = "conf/SqlMapConfig.xml";
		Reader reader = Resources.getResourceAsReader(conf);
		//创建SessionFactory对象
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory sf = sfb.build(reader);
		//创建Session
		SqlSession session = sf.openSession();
		System.out.println(session);
		
		//1.save
/*		Student s = new Student();
		s.setsNo("s099");
		s.setsName("Dragon");
		s.setsAge(18);
		s.setsSex("男");
		
		session.insert("save", s);
		session.commit();*/
		
		//2.update
/*		Student s = new Student();
		s.setsNo("s099");
		s.setsName("Dragon1939");
		s.setsAge(18);
		s.setsSex("男");
		
		session.update("update", s);
		session.commit();*/
		
		//3.delete
/*		session.delete("delete", "s099");
		session.commit();*/
		
		//4.findByNo
/*		Student s = session.selectOne("findByNo", "s001");
		System.out.println(s.toString());*/
		
		//5.findAll
/*		List<Student> list = session.selectList("findAll");
		System.out.println(list);*/
		
		//6.findByNoToMap
/*		Map<String, Object> map = session.selectOne("findByNoToMap", "s001");
		System.out.println(map);*/
		
		//7.findAllToMap
/*		List<Map<String, Object>> list = session.selectList("findAllToMap");
		System.out.println(list);*/
		
		//8.分页
/*		int offset = 0;//起点,从0开始
		int limit = 2;//查询几条
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Student> list = session.selectList("findAll",null,rowBounds);
		System.out.println(list);*/
		
		//9.使用Mapper映射器
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		List<Student> list = mapper.findAll();
		System.out.println(list);
		
		//关闭Session
		session.close();
	}
}













