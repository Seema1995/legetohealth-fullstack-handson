package com.fullstack.day3;

public class ExceptionSingleTryCatch {
	public static void main(String[] args) throws Exception{
		try {
			System.out.println("Inside outer try catch block..");
			int i = 10, j = 1;
			System.out.println(i / j);
			try {
				System.out.println("Inside nested try block..");
				int[] num = { 1, 2, 3, 4 };
				System.out.println("Num : " + num[4]);
			} catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
			}

		} catch (ArithmeticException e) {
			throw e;
		} catch (ArrayIndexOutOfBoundsException exe) {
			exe.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			System.out.println("Finally executed.");
		}
	}

}
