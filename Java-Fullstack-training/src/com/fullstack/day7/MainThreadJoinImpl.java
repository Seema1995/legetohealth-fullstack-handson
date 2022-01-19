package com.fullstack.day7;

public class MainThreadJoinImpl {

	public static void main(String[] args) {
		ThreadJoinImpl thread = new ThreadJoinImpl();
		ThreadJoinImpl thread2 = new ThreadJoinImpl();
		thread.setName("thread1");
		thread2.setName("thread2");
		
		//Thread 1 started
		thread.start();
		try {
			/*
			 * //Waits for this thread to die.Throws:InterruptedException - //if any thread
			 * has interrupted the current thread. The interrupted status //of the current
			 * thread is cleared when this exception is thrown.
			 */			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Thread 2 started
		thread2.start();
		try {
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
