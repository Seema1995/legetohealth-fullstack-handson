package day2;

public class Customer extends Person {

	private int customerId;
	private int accountNum;
	private double balance;
	
	public Customer(int customerId,String name, String gender, int accountNum, double balance) {
		super(name,gender);
		this.customerId = customerId;
		this.accountNum = accountNum;
		this.balance = balance;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void display() {
		System.out.println("Customer Details are  -");
		System.out.println("Customer Name : "+this.getName());
		System.out.println("Customer Gender : "+this.getGender());
		System.out.println("Customer Id : "+this.getCustomerId());
		System.out.println("Customer account no. : "+this.getAccountNum());
		System.out.println("Customer balance : "+this.getBalance());
		System.out.println("----------------------------------------------");
	}
	
}
