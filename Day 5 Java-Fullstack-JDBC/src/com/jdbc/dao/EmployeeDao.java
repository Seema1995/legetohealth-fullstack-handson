package com.jdbc.dao;

import java.util.List;

import com.jdbc.beans.Employee;
import com.jdbc.exception.EmployeeNotFoundException;

public interface EmployeeDao {

	public int store(Employee emp);

	public List<Employee> getAllEmployees() throws EmployeeNotFoundException;

	public int delEmpById(int delEmpId) throws EmployeeNotFoundException;

	public Employee findEmpById(int id) throws EmployeeNotFoundException;
	
	public int updateSalaryById(int id,double salary) throws EmployeeNotFoundException;

}
