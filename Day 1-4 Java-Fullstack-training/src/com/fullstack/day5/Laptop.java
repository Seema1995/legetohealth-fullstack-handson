package com.fullstack.day5;

import java.util.ArrayList;
import java.util.List;

public class Laptop {
	private int ramSize;
	private String laptopName;
	private double price;
	
	
	public Laptop(int ramSize, String laptopName, double price) {
		super();
		this.ramSize = ramSize;
		this.laptopName = laptopName;
		this.price = price;
	}
	public int getRamSize() {
		return ramSize;
	}
	public void setRamSize(int ramSize) {
		this.ramSize = ramSize;
	}
	public String getLaptopName() {
		return laptopName;
	}
	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Laptop [ramSize=" + ramSize + ", laptopName=" + laptopName + ", price=" + price + "]";
	}
	
	public static List<Laptop> getAllLaptops(){
		List<Laptop> laptops = new ArrayList<Laptop>();
		laptops.add(new Laptop(8,"Dell",45000));
		laptops.add(new Laptop(16,"Dell",55000));
		laptops.add(new Laptop(16,"Dell",65000));
		laptops.add(new Laptop(32,"Dell",75000));
		laptops.add(new Laptop(64,"Dell",125000));
		laptops.add(new Laptop(32,"Dell",85000));
		laptops.add(new Laptop(8,"HP",45000));
		laptops.add(new Laptop(16,"HP",55000));
		laptops.add(new Laptop(16,"HP",65000));
		laptops.add(new Laptop(32,"Lenovo",75000));
		laptops.add(new Laptop(64,"Lenovo",125000));
		laptops.add(new Laptop(32,"Acer",85000));
		return laptops;
	}

}
