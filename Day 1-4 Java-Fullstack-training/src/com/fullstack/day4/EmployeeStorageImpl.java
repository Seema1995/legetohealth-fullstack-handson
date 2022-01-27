package com.fullstack.day4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class EmployeeStorageImpl implements EmployeeStorage {

	List<Employee> empList = new ArrayList<Employee>();

	@Override
	public int save(Employee e) {
		empList.add(e);
		try {
			FileOutputStream fos = new FileOutputStream("EmployeeText.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(e);
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

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
		// File output display
		System.out.println(" Below are the details from the file -");
		try {
			Object obj;
			FileInputStream fis = new FileInputStream("EmployeeText.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			while ((obj = ois.readObject()) != null) {
				if (obj instanceof Employee) {
					System.out.println(((Employee) obj).toString());
				}
			}
			ois.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
