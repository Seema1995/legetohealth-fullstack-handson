package com.fullstack.day1;

import java.util.Scanner;

public class Exercise5 {
	final static int[] numList = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	final static String[] words = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 3 digit number : ");
		int number = scan.nextInt();

		String numToWords = convertNumToWords(number);
		System.out.println("The given no.s in words : " + numToWords);
		scan.close();
	}

	public static String convertNumToWords(int num) {
		String temp = Integer.toString(num);
		int[] numbers = new int[temp.length()];
		StringBuffer wordsConverted = new StringBuffer();

		for (int i = 0; i < temp.length(); i++) {
			numbers[i] = temp.charAt(i) - '0';
		}
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numList.length; j++) {
				if (numbers[i] == numList[j]) {
					wordsConverted.append(words[j]+" ");
					break;
				}
			}
		}
		return wordsConverted.toString();
	}

}
