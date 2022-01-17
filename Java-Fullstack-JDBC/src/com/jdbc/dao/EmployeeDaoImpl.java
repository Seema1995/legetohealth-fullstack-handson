package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jdbc.beans.Employee;
import com.jdbc.exception.EmployeeNotFoundException;

public class EmployeeDaoImpl implements EmployeeDao {

	public int store(Employee emp) {
		int status = -1;
		try {
			Connection conn = DBUtil.getConnection();

			String query = "insert into employee(name,salary) values(?,?)";

			PreparedStatement pstatement = conn.prepareStatement(query);
			pstatement.setString(1, emp.getEmpName());
			pstatement.setDouble(2, emp.getEmpSalary());

			status = pstatement.executeUpdate();

			pstatement.close();
			conn.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return status;

	}

	public List<Employee> getAllEmployees() throws EmployeeNotFoundException{
		List<Employee> employees = new ArrayList<Employee>();
		try {
			Connection conn = DBUtil.getConnection();
			String query = "select * from employee";
			PreparedStatement pstatement = conn.prepareStatement(query);
			ResultSet result = pstatement.executeQuery();
			System.out.println(result.getMetaData().getColumnCount());
			if(result.isBeforeFirst()) {
				while(result.next()){
					Employee e = new Employee(result.getInt(1),result.getString(2),result.getDouble(3));
				    employees.add(e);
				}
			}
			else {
				throw new EmployeeNotFoundException("No Employees are present in database");
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	public Employee findEmpById(int id) throws EmployeeNotFoundException {
		Employee e = null;
		try {
			Connection conn = DBUtil.getConnection();
			String query = "select * from employee where id = ?";
			PreparedStatement pstatement = conn.prepareStatement(query);
			pstatement.setInt(1, id);
			ResultSet result = pstatement.executeQuery();
			while (result.next()) {
				e = new Employee(result.getInt(1), result.getString(2), result.getDouble(3));
			}

			if (e == null)
				throw new EmployeeNotFoundException("Employee with id " + id + " not found.Try again.");

			result.close();
			pstatement.close();
			conn.close();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return e;

	}

	public int delEmpById(int delEmpId) throws EmployeeNotFoundException {
		int result = -1;
		try {
			Connection conn = DBUtil.getConnection();
			String query = "delete from employee where id = ?";
			PreparedStatement pstatement = conn.prepareStatement(query);
			pstatement.setInt(1, delEmpId);
			result = pstatement.executeUpdate();

			if (result == 0)
				throw new EmployeeNotFoundException(
						"Employee with id " + delEmpId + " cannot be found so cannot be deleted. Try again.");
			pstatement.close();
			conn.close();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return result;

	}

	public int updateSalaryById(int id, double salary) throws EmployeeNotFoundException {
		int result = 0;
		try {
			Connection conn = DBUtil.getConnection();
			String query = "update employee set salary = ? where id = ?";
			PreparedStatement pstatement = conn.prepareStatement(query);
			
			pstatement.setDouble(1, salary);
			pstatement.setInt(2, id);
			result = pstatement.executeUpdate();

			if(result==0) throw new EmployeeNotFoundException("Employee with id "+id+" not found. No update was done. Try again.");
			
			pstatement.close();
			conn.close();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return result;

	}

}
 