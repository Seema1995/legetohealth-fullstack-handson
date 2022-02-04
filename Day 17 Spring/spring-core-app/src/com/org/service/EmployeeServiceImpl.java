package com.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl {
	
	EmployeeDAO dao;

	
	//Using Constructor injection to inject dependency
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO dao){
		System.out.println("EmployeeServiceimpl created!!!");
		this.dao = dao;
	}

	//Using Setter Injection way to perform Dependency Injection
//	public void setDao(EmployeeDAO dao) {
//		this.dao = dao;
//	}
	
	public void save() {
		System.out.println("Inside save() of EmployeeService...");
		dao.store();
		dao.delete();
	}
	

}
