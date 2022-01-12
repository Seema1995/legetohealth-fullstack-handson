package com.fullstack.day3;

public class MathClass2 extends MathClass1 implements MathCalculations,ScientificCalculations {

	@Override
	public int add(int num1, int num2) {
		return num1 + num2;
	}

	@Override
	public int sub(int num1, int num2) {
		return num1 - num2;
	}


	@Override
	public double sqroot(int num) {
		return Math.sqrt(num);
	}

	@Override
	public double powerOf(int num1, int num2) {
		return Math.pow(num1, num2);
	}

	@Override
	public void message() {
		System.out.println("I saw the Sin :)");
		
	}

}
