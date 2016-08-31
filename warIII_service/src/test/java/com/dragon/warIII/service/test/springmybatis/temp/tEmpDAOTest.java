package com.dragon.warIII.service.test.springmybatis.temp;

import java.sql.Timestamp;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dragon.warIII.core.test.SuperTest;
import com.dragon.warIII.service.emp.dao.TEmpDAO;
import com.dragon.warIII.service.emp.entity.TEmp;
@Ignore
public class tEmpDAOTest  extends SuperTest{

	@Autowired
	private TEmpDAO tEmpDAO;
	
	@Test
	public void testSave() {
		TEmp tEmp = new TEmp();
		tEmp.setEname("zhangsan");
		tEmp.setJob("Salesman");
		tEmp.setMgr(2);
		tEmp.setHiredate(new Timestamp(System.currentTimeMillis()));
		tEmp.setSal(4000.0);
		tEmp.setComm(500.0);
		tEmp.setDeptno(10);
		
		int num = tEmpDAO.save(tEmp);
		System.out.println("num="+num);
	}
}
