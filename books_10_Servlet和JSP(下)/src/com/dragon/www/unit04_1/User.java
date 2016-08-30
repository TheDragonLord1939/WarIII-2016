package com.dragon.www.unit04_1;

public class User {

	private String name;
	private int age;
	private Course course;
	private String[] interest;
	
	
	public User(String name, int age, Course course, String[] interest) {
		super();
		this.name = name;
		this.age = age;
		this.course = course;
		this.interest = interest;
	}
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String[] getInterest() {
		return interest;
	}
	public void setInterest(String[] interest) {
		this.interest = interest;
	}
	
	
}
