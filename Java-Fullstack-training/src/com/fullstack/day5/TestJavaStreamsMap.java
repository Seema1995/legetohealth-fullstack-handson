package com.fullstack.day5;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TestJavaStreamsMap {

	public static void main(String[] args) {
		List<Laptop> laptops = Laptop.getAllLaptops();
		
		//count() and map() implementation
		Set<String> laptopsCollectedToList = laptops.stream().filter(laptop->laptop.getPrice()>60000).map(laptop->laptop.getLaptopName()).collect(Collectors.toSet());
		System.out.println("Laptops available with price above 60000 : "+laptopsCollectedToList.stream().count());
		System.out.println(laptopsCollectedToList);
		System.out.println();
		
		Set<Integer> laptopsCollectedToSetBySize = laptops.stream().map(laptop->laptop.getRamSize()).collect(Collectors.toSet());
		System.out.println("RAM size options for Laptops : "+laptopsCollectedToSetBySize.stream().count());
		System.out.println(laptopsCollectedToSetBySize);
		System.out.println();
		
		//forEach() implementation
		System.out.println("Laptops with price above 60000 displayed using forEach : ");
		laptopsCollectedToList.stream().forEach(System.out::println);
		
		//parallel Stream implementation

	}

}
