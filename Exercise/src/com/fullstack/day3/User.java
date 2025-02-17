package com.fullstack.day3;

public class User {
	private String userName;
	private int id;
	private int age;
	
	
	
	public User(String userName, int id, int age) {
		super();
		this.userName = userName;
		this.id = id;
		this.age = age;
	}
	public User() {
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", id=" + id + ", age=" + age + "]";
	}

}
