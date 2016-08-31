package com.dragon.warIII.unit02.case2.entity;

import java.io.Serializable;

/**
 * @description 功能描述: 学生实体类
 * @author 作 者: L.D
 * @createdate 建立日期：2016-6-26
 * @projectname 项目名称: warIII_service
 * @packageclass 包及类名: com.dragon.warIII.service.student.entity   Student.java
 */
public class Student implements Serializable{

	private static final long serialVersionUID = 1L;

	private String sNo;//学号
	private String sName;//姓名
	private Integer sAge;//年龄
	private String sSex;//性别
	
	public Student() {
		super();
	}


	public Student(String sNo, String sName, Integer sAge, String sSex) {
		super();
		this.sNo = sNo;
		this.sName = sName;
		this.sAge = sAge;
		this.sSex = sSex;
	}


	public String getsNo() {
		return sNo;
	}

	public void setsNo(String sNo) {
		this.sNo = sNo;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public Integer getsAge() {
		return sAge;
	}

	public void setsAge(Integer sAge) {
		this.sAge = sAge;
	}

	public String getsSex() {
		return sSex;
	}

	public void setsSex(String sSex) {
		this.sSex = sSex;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Student [sNo=" + sNo + ", sName=" + sName + ", sAge=" + sAge
				+ ", sSex=" + sSex + "]";
	}
	
}
