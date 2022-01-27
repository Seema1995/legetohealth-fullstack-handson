package com.fullstack.day1;

public class Exercise3 {

	public static void main(String[] args) {
		int numList[] =  {2,5,-1};
		System.out.println("The biggest num in given three nums is : "+findLargest(numList));
	}
	
	public static int findLargest(int[] numList) {
		
		int biggestNum = numList[0];
		
		for(int i=1;i<numList.length;i++) {
			if(biggestNum<numList[i]) {
				biggestNum = numList[i];
			}
		}
		return biggestNum;
	}

}
