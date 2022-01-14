package com.fullstack.day4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class EmployeeStorageImpl implements EmployeeStorage {

	List<Employee> empList = new ArrayList<Employee>();

	@Override
	public int save(Employee e) {
		empList.add(e);
		return e.getId();
	}

	@Override
	public Employee findEmployee(int id) throws EmployeeNotFoundException {
		for (Employee e : empList) {
			int eId = e.getId();
			if (eId == id)
				return e;
		}
		throw new EmployeeNotFoundException("Employee not found!!");
	}

	@Override
	public Employee[] findEmployees() {
		Employee[] eList = new Employee[empList.size()];
		eList = empList.toArray(eList);
		return eList;
	}

	@Override
	public void delete(int id) throws EmployeeNotFoundException {
		boolean empFound = false;
		Iterator<Employee> iterator = empList.listIterator();
		while (iterator.hasNext()) {
			Employee e = iterator.next();
			int eId = e.getId();
			if (eId == id) {
				iterator.remove();
				empFound = true;
			}
		}
		if (!empFound)
			throw new EmployeeNotFoundException("Employee not found!!");
	}

}
