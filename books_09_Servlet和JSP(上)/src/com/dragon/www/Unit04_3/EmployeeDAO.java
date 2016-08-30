package com.dragon.www.Unit04_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmployeeDAO {

	public List<Employee> findAll() {
		List<Employee> list = new ArrayList<Employee>();
		for (int i=0; i<5; i++) {
			Employee e = new Employee();
			e.setId(0000+i);
			e.setName("lili"+i);
			e.setAge(i+20);
			e.setSalary(i*1000+i);
			list.add(e);
		}
		return list;
	}
	
}
