package com.dragon.warIII.service.course.entity;

import java.io.Serializable;

import com.dragon.warIII.service.teacher.entity.Teacher;

/**
 * @description 功能描述: 课程数据库访问实体类
 * @author 作 者: L.D
 * @date 建立日期：2016-7-5
 * @name 项目名称: warIII_service
 * @package 包及类名: com.dragon.warIII.service.course.entity   Course.java
 * @version 1.0
 * @copyright ©2016-2026 瀧腾科技股份有限公司. All Rights Reserved.
 */
public class Course implements Serializable{

	private static final long serialVersionUID = -7372343355317839986L;
	
	private String cNo;		//课程ID
	private String cName;   //课程名
	private String tNo;		//教师ID
	
	private Teacher teacher;	//关联属性,用于封装课程对应的任课教师信息
	
	public Course() {
		super();
	}

	public Course(String cNo, String cName, String tNo) {
		super();
		this.cNo = cNo;
		this.cName = cName;
		this.tNo = tNo;
	}

	public String getcNo() {
		return cNo;
	}

	public void setcNo(String cNo) {
		this.cNo = cNo;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String gettNo() {
		return tNo;
	}

	public void settNo(String tNo) {
		this.tNo = tNo;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	@Override
	public String toString() {
		return "Course [cNo=" + cNo + ", cName=" + cName + ", tNo=" + tNo
				+ ", teacher=" + teacher + "]";
	}

}

