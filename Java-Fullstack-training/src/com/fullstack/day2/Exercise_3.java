package com.fullstack.day2;

public class Exercise_3 {
	public static void main(String[] args) {
		StudentClass student1 = new StudentClass();
		student1.setStudentId(101);
		student1.setStudentName("Alice");
		student1.setCity("Chicago");
		student1.setMarks1(60);
		student1.setMarks2(65);
		student1.setMarks3(65);
		student1.setFeePerMonth(12000.0F);
		student1.setEligibleForScholarship(true);

		StudentClass student2 = new StudentClass();
		student2.setStudentId(104);
		student2.setStudentName("Bob");
		student2.setCity("NY");
		student2.setMarks1(70);
		student2.setMarks2(75);
		student2.setMarks3(85);
		student2.setFeePerMonth(2000.0F);
		student2.setEligibleForScholarship(true);

		StudentClass student3 = new StudentClass();
		student3.setStudentId(194);
		student3.setStudentName("Charlie");
		student3.setCity("Texas");
		student3.setMarks1(90);
		student3.setMarks2(95);
		student3.setMarks3(85);
		student3.setFeePerMonth(14000.0F);
		student3.setEligibleForScholarship(false);

		System.out.println(getStudentNameWithHighestMarks(student1, student2, student3));

		lowestFeePayingStudent(student1, student2, student3);

		StudentClass[] students = { student1, student2, student3 };
		displayStudentInfo(students);

	}

	public static String getStudentNameWithHighestMarks(StudentClass s1, StudentClass s2, StudentClass s3) {

		if (s1.getTotalMarks() > s2.getTotalMarks() && s1.getTotalMarks() > s3.getTotalMarks())
			return "Student with Highest Total Marks : " + s1.getStudentName();
		else if (s2.getTotalMarks() > s1.getTotalMarks() && s2.getTotalMarks() > s3.getTotalMarks())
			return "Student with Highest Total Marks : " + s2.getStudentName();
		else
			return "Student with Highest Total Marks : " + s3.getStudentName();
	}

	public static void lowestFeePayingStudent(StudentClass s1, StudentClass s2, StudentClass s3) {
		System.out.println("-------------------------------------------------------------------");
		if (s1.getAnnualFee() < s2.getAnnualFee() && s1.getAnnualFee() < s3.getAnnualFee())
			System.out.println("Student " + s1.getStudentName() + " pays least annual fee of Rs. " + s1.getAnnualFee());
		else if (s2.getAnnualFee() < s1.getAnnualFee() && s2.getAnnualFee() < s3.getAnnualFee())
			System.out.println("Student " + s2.getStudentName() + " pays least annual fee of Rs. " + s2.getAnnualFee());
		else
			System.out.println("Student " + s3.getStudentName() + " pays least annual fee of Rs. " + s3.getAnnualFee());
	}

	public static void displayStudentInfo(StudentClass[] s) {
		System.out.println("-------------------------------------------------------------------");
		for (StudentClass student : s) {
			System.out.println("Student Name : " + student.getStudentName());
			System.out.println("Student Total Marks : " + student.getTotalMarks());
			System.out.println("Student Average Marks : " + student.getAverage());
			System.out.println("Student Result : " + student.getResult());
			System.out.println("Student Scholarship details : "
					+ (student.isEligibleForScholarship() == true ? "Scholarship available"
							: "Scholarship not available"));
			System.out.println("-------------------------------------------------------------------");
		}
	}
}
