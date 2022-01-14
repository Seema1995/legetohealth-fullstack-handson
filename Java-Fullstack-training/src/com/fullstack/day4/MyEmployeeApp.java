package com.fullstack.day4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyEmployeeApp {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int option = 0;
		EmployeeFactoryImpl eFactory = new EmployeeFactoryImpl();
		EmployeeStorageImpl empStorage = eFactory.getEmployeeStorageInstance();

		System.out.println("*********** Welcome to Employee Application ***********");
		System.out.println();
		System.out.println("Please select option to proceed or press 5 to exit...");
		System.out.println();
		System.out.println(
				" 1. Save Employee \r\n 2. Search Employee \r\n 3. Find all Employees \r\n 4. Delete Employee \r\n 5. Exit");

		loop: while (scan.hasNextInt()) {
			try {
				option = scan.nextInt();
			} catch (InputMismatchException exception) {
				System.out.println("Invalid Input. Try again");
			}
			switch (option) {
			case 1:
				System.out.println("Please enter Employee details - ");
				System.out.println("Employee Id : ");
				int id = scan.nextInt();
				System.out.println("Employee Name : ");
				String name = scan.next();
				System.out.println("Employee Salary : ");
				double salary = scan.nextDouble();
				Employee e = new Employee(id, name, salary);
				empStorage.save(e);
				System.out.println("Employee added successfully !!");
				break;
			case 2:
				System.out.println("Please enter the employee's Id you want to search : ");
				int eId = scan.nextInt();
				try {
					Employee emp = empStorage.findEmployee(eId);
					System.out.println("Below are the employee details - ");
					System.out.println(emp.toString());
				} catch (EmployeeNotFoundException e1) {
					System.out.println(e1.getMessage());
				}
				break;
			case 3:
				Employee[] employees = empStorage.findEmployees();
				if (null != employees) {
					System.out.println("Below are the list of employees - ");
					System.out.println("******************************************");
					for (Employee emps : employees) {
						System.out.println(emps.toString());
						System.out.println("---------------------------------------------");
					}
				} else {
					System.out.println("No employees present !! ");
				}
				break;

			case 4:
				System.out.println("Enter Employee Id to be deleted : ");
				int eIdDel = scan.nextInt();
				try {
					empStorage.delete(eIdDel);
					System.out.println("Employee with Id " + eIdDel + " deleted successfully !!");
				} catch (EmployeeNotFoundException e1) {
					e1.printStackTrace();
				}
				break;
			case 5:
				break loop;
			default:
				System.out.println("Invalid option . Please try again .");

			}
			System.out.println("Please select option to proceed or press 5 to exit...");
			System.out.println();
			System.out.println(
					" 1. Save Employee \r\n 2. Search Employee \r\n 3. Find all Employees \r\n 4. Delete Employee \r\n 5. Exit");

		}
		scan.close();
	}
}
