package com.dragon.warIII.json.entity;

public class Friend {

	private String name;
	private int age;
	
	public Friend() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Friend(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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

	@Override
	public String toString() {
		return "Friend [name=" + name + ", age=" + age + "]";
	}
	
}
