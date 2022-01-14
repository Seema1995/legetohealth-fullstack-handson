package com.fullstack.day4;

public class EmployeeFactoryInterfaceImpl {

	public Employee getEmployeeIntsance() {
		return new Employee();
	}
	
	public EmployeeStorageImpl getEmployeeStorageInstance() {
		return new EmployeeStorageImpl();
	}

}
