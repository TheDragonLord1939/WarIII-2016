package com.dragon.www.unit04_1;

/**
 *实体类：课程
 */
public class Course {

	private int courseId;
	private String courseName;
	
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(int courseId, String courseName) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
}
