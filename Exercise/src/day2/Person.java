package day2;

public class Person {

	public String name;
	public String gender;
	
	public Person() {
		
	}
	public Person(String name, String gender) {
		super();
		this.name = name;
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void display() {
		System.out.println("Person details are - " );
		System.out.println("Person Name : "+this.getName());
		System.out.println("Person Gender : "+this.getGender());
		System.out.println("----------------------------------------------");
	}
	
	
}
