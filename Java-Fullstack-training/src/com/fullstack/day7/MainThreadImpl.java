package com.fullstack.day7;

public class MainThreadImpl {

	public static void main(String[] args) {
		ThreadImpl thread = new ThreadImpl();
		Thread thread1 = new Thread(thread,"First Thread");
		Thread thread2 = new Thread(thread,"Second Thread");
		Thread thread3 = new Thread(thread,"Third Thread");
		
		//Daemon threads depends on parent threads, if parent thread is terminated daemon thread also terminates
		thread3.setDaemon(true);
		thread3.start();
		
		thread1.setDaemon(true);
		thread1.start();
		
		thread2.setDaemon(true);
		thread2.start();
		
		
	}

}
