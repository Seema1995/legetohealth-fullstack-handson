package com.jdbc.factory;

import com.jdbc.dao.EmployeeDaoImpl;

public class EmployeeDaoImplFactory {

	public static EmployeeDaoImpl getInstance() {
		return new EmployeeDaoImpl();
	}
}
