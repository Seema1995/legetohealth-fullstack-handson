package com.fullstack.day2;

public class Exercise_2 {

	public static void main(String[] args) {
		Person p = new Person("Rohan","M");
		print(p);
		
		Employee e = new Employee(1,"Sanket","M",10000);
		print(e);
		
		Student s = new Student(2,"Sangita","F",'A');
		print(s);
		
		Customer c= new Customer(1001,"Raj","M",100896735,12500.0);
		print(c);
		
	}
	
	public static void print(Person person) {
		
		person.display();
	}

}
