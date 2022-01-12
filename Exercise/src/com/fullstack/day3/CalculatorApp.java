package com.fullstack.day3;

public class CalculatorApp {

	public static void main(String[] args) {
		MathCalculations m = new MathClass2();

		System.out.println("Math Calculator -----------------");
		System.out.println("Addition of two numbers : " + m.add(8, 9));
		System.out.println("Substraction of two numbers : " + m.sub(8, 9));
		System.out.println("Square root of 8 : " + m.sqroot(8));
		System.out.println("Power of 2*3 : " + m.powerOf(2, 3));
		
		System.out.println();
		
		ScientificCalculations s = new MathClass2();
		System.out.println("Scientific Calculator -----------------");
		System.out.println("Scientific Calculator message : ");
		s.message();
	}

}
