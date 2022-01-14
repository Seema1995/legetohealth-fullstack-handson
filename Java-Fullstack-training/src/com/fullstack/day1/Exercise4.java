package com.fullstack.day1;

public class Exercise4 {

	public static void main(String[] args) {
		int numList[] =  {9,5,-1};
		System.out.println("The sum of biggest and smallest num in given three nums is : "+findSum(numList));
	}
	public static int findSum(int []list) {
		int smallest = list[0];
		int biggest = list[0];
		
		for(int i=1;i<list.length;i++) {
			if(biggest<list[i]) {
				biggest = list[i];
			}
			if(smallest>list[i]) {
				smallest = list[i];
			}
		}
		System.out.println("The biggest num is : "+biggest);
		System.out.println("The smallest num is : "+smallest);
		return smallest+biggest;
		
	}

}
