package com.dragon.war.boot.entity;

/**
 * @description 功能描述: 测试实体类
 * @author 作 者: L.D
 * @createdate 建立日期：2016-10-12
 * @projectname 项目名称: SpringBoot-001-HelloWorld
 * @packageclass 包及类名: com.dragon.war.boot.entity  Demo.java
 */
public class Demo {

	private long id;	//主键.
	private String name;	//测试名称
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
