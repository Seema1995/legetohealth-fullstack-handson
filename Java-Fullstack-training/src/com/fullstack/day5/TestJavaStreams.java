package com.fullstack.day5;

import java.util.List;
import java.util.stream.Collectors;

public class TestJavaStreams {
	public static void main(String[] args) {
		List<Laptop> laptops = Laptop.getAllLaptops();

		List<Laptop> laptopGtThan8Gb = laptops.stream().filter(laptop -> laptop.getRamSize() > 8)
				.collect(Collectors.toList());
		printAllLaptops(laptopGtThan8Gb);
		System.out.println();
		
		List<Laptop> laptopGtThan8GbNotHP = laptopGtThan8Gb.parallelStream()
				.filter(laptop -> laptop.getLaptopName() != "HP").collect(Collectors.toList());
		printAllLaptops(laptopGtThan8GbNotHP);
		System.out.println();

		List<Laptop> laptopGtThan8GbNotHPSortedByPrice = laptopGtThan8GbNotHP.stream()
				.sorted((laptop1, laptop2) -> Double.compare(laptop1.getPrice(), laptop2.getPrice()))
				.collect(Collectors.toList());
		printAllLaptops(laptopGtThan8GbNotHPSortedByPrice);
		System.out.println();

	}
	
	public static void printAllLaptops(List<Laptop> laptops) {
		laptops.stream().forEach(laptop->System.out.println(laptop.toString()));
	}
}
