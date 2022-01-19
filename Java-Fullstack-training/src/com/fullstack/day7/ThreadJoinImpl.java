package com.fullstack.day7;

public class ThreadJoinImpl extends Thread {

	public void run() {
		executeTask();
	}
	
	public void executeTask() {
		System.out.println("I am "+Thread.currentThread().getName());
		for(int i=1;i<=12;i++) {
			System.out.println("This is "+i+" iteration of "+getName());
		}
	}
}
