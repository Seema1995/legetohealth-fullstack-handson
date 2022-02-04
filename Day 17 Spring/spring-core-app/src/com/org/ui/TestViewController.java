package com.org.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.org.service.EmployeeServiceImpl;

public class TestViewController {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		
		EmployeeServiceImpl service = (EmployeeServiceImpl) context.getBean("employeeServiceImpl");
		service.save();
	
	}

}
