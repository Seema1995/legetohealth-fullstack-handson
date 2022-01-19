package com.fullstack.day7;

public class ThreadImpl extends Thread{

	public void run() {
		performTask();
	}
	
	public void performTask() {
		System.out.println("Thread : "+Thread.currentThread().getName()+" is in control");
		for(int i=0;i<10;i++) {
			System.out.println("Thread : "+Thread.currentThread().getName()+ " i : "+i);
		}
		System.out.println();
	}
}
