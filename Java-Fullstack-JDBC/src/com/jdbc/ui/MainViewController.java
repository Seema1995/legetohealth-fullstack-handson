package com.jdbc.ui;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.jdbc.beans.Employee;
import com.jdbc.dao.EmployeeDao;
import com.jdbc.exception.EmployeeNotFoundException;
import com.jdbc.factory.EmployeeDaoImplFactory;

public class MainViewController {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int option = 0;
		boolean doILoop = false;

		EmployeeDao dao = EmployeeDaoImplFactory.getInstance();

		do {
			System.out.println("Select one of the options below to perform CRUD operations -");
			System.out.println(
					"1. Store employee  \r\n2. Fetch all employees \r\n3. Fetch employee by id \r\n4. Delete employee by id \r\n5. Upate employee slaary by id \r\n6. Exit");
			try {
				option = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Try again.");
			}
			scan.next();
			switch (option) {
			case 1:
				System.out.println("Enter name : ");
				String eName = scan.next();
				System.out.println("Enter salary : ");
				double eSal = scan.nextDouble();
				Employee e = new Employee(0, eName, eSal);
				int status = dao.store(e);
				if (status == -1) {
					System.out.println("Employee not stored.");
				} else {
					System.out.println("Employee store successfully!!!");
				}
				break;
			case 2:
				List<Employee> emp;
				try {
					emp = dao.getAllEmployees();
					if (emp != null)
						for (Employee employees : emp)
							System.out.println(employees.toString());
				} catch (EmployeeNotFoundException e3) {
					System.out.println(e3.getMessage());
				}
				break;
			case 3:
				System.out.println("Enter employee id to be searched : ");
				int id = scan.nextInt();
				Employee employee;
				try {
					employee = dao.findEmpById(id);
					System.out.println(employee.toString());
				} catch (EmployeeNotFoundException e2) {
					System.out.println(e2.getMessage());
				}

				break;
			case 4:
				System.out.println("Enter id of the employee to be deleted : ");
				int delEmpId = scan.nextInt();
				int statusDel;
				try {
					statusDel = dao.delEmpById(delEmpId);
					if (statusDel == -1) {
						System.out.println("Employee Not found!!");
					} else {
						System.out.println("Employee deleted successfully!!!");
					}
				} catch (EmployeeNotFoundException e1) {
					System.out.println(e1.getMessage());
				}
				break;
			case 5:
				System.out.println("Enter Employee id : ");
				int eId = scan.nextInt();
				System.out.println("Enter salary : ");
				double sal = scan.nextDouble();
				int statusUpdate;
				try {
					statusUpdate = dao.updateSalaryById(eId, sal);
					if (statusUpdate > 0)
						System.out.println("Employee's salary updates successfully!!!");
				} catch (EmployeeNotFoundException e1) {
					System.out.println(e1.getMessage());
				}
				break;
			case 6:
				System.out.println("Exited.");
				doILoop = true;
				break;
			}
		} while (!doILoop);

		scan.close();
	}

}
