package day2;

public class Employee extends Person {
	private int employeeId;
	private double salary;
	
	public Employee(int employeeId,String name, String gender, double salary) {
		super(name,gender);
		this.employeeId = employeeId;
		this.salary = salary;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void display() {
		System.out.println("Employee Details are  -");
		System.out.println("Employee Name : "+this.getName());
		System.out.println("Employee Gender : "+this.getGender());
		System.out.println("Employee Id : "+this.getEmployeeId());
		System.out.println("Employee Salary : "+this.getSalary());
		System.out.println("----------------------------------------------");
	}

}
