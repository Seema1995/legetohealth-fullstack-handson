package com.fullstack.day2;

public class StudentClass {

	private int studentId;
	private String studentName;
	private String city;
	private int marks1;
	private int marks2;
	private int marks3;
	private float feePerMonth;
	private boolean isEligibleForScholarship;
	
	public StudentClass(int studentId, String studentName, String city, int marks1, int marks2, int marks3,
			float feePerMonth, boolean isEligibleForScholarship) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.city = city;
		this.marks1 = marks1;
		this.marks2 = marks2;
		this.marks3 = marks3;
		this.feePerMonth = feePerMonth;
		this.isEligibleForScholarship = isEligibleForScholarship;
	}
	public StudentClass() {
		// TODO Auto-generated constructor stub
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getMarks1() {
		return marks1;
	}
	public void setMarks1(int marks1) {
		this.marks1 = marks1;
	}
	public int getMarks2() {
		return marks2;
	}
	public void setMarks2(int marks2) {
		this.marks2 = marks2;
	}
	public int getMarks3() {
		return marks3;
	}
	public void setMarks3(int marks3) {
		this.marks3 = marks3;
	}
	public float getFeePerMonth() {
		return feePerMonth;
	}
	public void setFeePerMonth(float feePerMonth) {
		this.feePerMonth = feePerMonth;
	}
	public boolean isEligibleForScholarship() {
		return isEligibleForScholarship;
	}
	public void setEligibleForScholarship(boolean isEligibleForScholarship) {
		this.isEligibleForScholarship = isEligibleForScholarship;
	}
	
	public float getAnnualFee() {
		return this.getFeePerMonth()*12;
	}
	
	public int getTotalMarks() {
		return this.getMarks1()+this.getMarks2()+this.getMarks3();
	}
	
	public float getAverage() {
		return this.getTotalMarks()/3;
	}
	
	public String getResult() {
		if(this.getMarks1()>60 && this.getMarks2()>60 && this.getMarks3()>60) return "Pass";
		
		return "Fail";
	}
	
}
