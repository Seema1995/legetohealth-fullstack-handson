package com.org.dao;

import org.springframework.stereotype.Repository;

//This annotation enables IOC container to instantiate the class
//by default bean id for instantiation is employeeJDBCImpl
//If you want to override you can specify @Service("empService")
@Repository
public class EmployeeJDBCImpl implements EmployeeDAO {

	public EmployeeJDBCImpl() {
		System.out.println("EmployeeJDBCImpl bean created !!!");
	}
	@Override
	public void store() {
		System.out.println("Inside store() EmployeeJDBCImpl...");
	}

	@Override
	public void delete() {
		System.out.println("Inside delete() EmployeeJDBCImpl...");
	}

}
