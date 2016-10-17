package com.dragon.war.boot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * @description 功能描述: 测试实体类
 * @author 作 者: L.D
 * @createdate 建立日期：2016-10-12
 * @projectname 项目名称: SpringBoot-001-HelloWorld
 * @packageclass 包及类名: com.dragon.war.boot.entity  Demo.java
 */
@Entity	//加入这个注解，Demo就会进行持久化了，在这里没有对@Table进行配置，请自行配置
@Table(name="DEMO")
public class Demo {

	@Id
	@SequenceGenerator(name="seq_demo")
	private Integer id;	//主键.
	private String name;	//测试名称
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
