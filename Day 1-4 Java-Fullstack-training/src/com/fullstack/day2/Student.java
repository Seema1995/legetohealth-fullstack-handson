package com.fullstack.day2;

public class Student extends Person {

	private int rollNo;
	private char grade;
	
	public Student(int rollNo,String name,String gender, char grade) {
		super(name,gender);
		this.rollNo = rollNo;
		this.grade = grade;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	
	public void display() {
		System.out.println("Student Details are  -");
		System.out.println("Student Name : "+this.getName());
		System.out.println("Student Gender : "+this.getGender());
		System.out.println("Student Id : "+this.getRollNo());
		System.out.println("Student Grade : "+this.getGrade());
		System.out.println("----------------------------------------------");
	}
	
	
}
