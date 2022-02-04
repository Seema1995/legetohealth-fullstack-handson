package com.org.dao;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeOrmImpl implements EmployeeDAO{

	public EmployeeOrmImpl() {
		System.out.println("EmployeeOrmImpl bean created !!!");
	}
	@Override
	public void store() {
		System.out.println("Inside store() of EmployeeOrmImpl....");
	}

	@Override
	public void delete() {
		System.out.println("Inside delete() of EmployeeOrmImpl....");
	}

}
