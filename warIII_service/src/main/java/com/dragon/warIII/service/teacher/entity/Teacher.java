package com.dragon.warIII.service.teacher.entity;

import java.io.Serializable;
import java.util.List;

import com.dragon.warIII.service.course.entity.Course;

public class Teacher implements Serializable {

	private static final long serialVersionUID = 8702414780426852983L;

	private String tNo;
	private String tName;

	private List<Course> courses;

	public Teacher() {
		super();
	}

	public Teacher(String tNo, String tName, List<Course> courses) {
		super();
		this.tNo = tNo;
		this.tName = tName;
		this.courses = courses;
	}

	public String gettNo() {
		return tNo;
	}

	public void settNo(String tNo) {
		this.tNo = tNo;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Teacher [tNo=" + tNo + ", tName=" + tName + ", courses="
				+ courses + "]";
	}

}
