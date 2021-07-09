package org.yanixmrml;

public class DeadLockApp {
	//Scenario is Thread1 holds the Resource1 and Thread2 holds the Resource2, but Thread1 needs Resource1 and Thread2 needs Resource2 so therefore there is deadlock
	//Lock objects can't be shared
	
	public static void main(String args[]) {
		String lock1 = "lock1";
		String lock2 = "lock2";
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(lock1) {
					System.out.println("Inside thread1 on lock1");
					synchronized(lock2) {
						System.out.println("Inside thread1 on lock2");
					}
				}
			}
			
		});
		
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized(lock2) {
					//if lock2 is accessed it will be hold by the thread2 and will cause intersection between thread 1
					System.out.println("Inside thread2 on lock2");
					synchronized(lock1) {
						System.out.println("Inside thread2 on lock1");
					}
				}
			}
			
		});
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Inside main method");
		
	}

}
