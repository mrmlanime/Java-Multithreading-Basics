package org.yanixmrml;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockThread {
	
	public static int counter = 0;
	public static Lock lock = new ReentrantLock();
	
	public static void main(String args[]) throws InterruptedException {
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				lock.lock();
				try {
					for(int i=0;i<100000;i++) {
						ReentrantLockThread.counter++;
					}
				}finally {
					lock.unlock();
				}	
			}
			
		});
		
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				lock.lock(); //lock means wait for other thread to finish, so it means doesn't execute the code below
				//simultaneously
				try {
					for(int i=0;i<100000;i++) {
						ReentrantLockThread.counter++;
					}
				}finally {
					lock.unlock(); //Please put this in finally block in a try catch, good practice
				}
			}
			
		});
		//Benefit of Reentrack, better control, manual manipulation
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		System.out.println("The value of counter : " + counter);
		
		//In reentrant lock find the root-cause of interference of the inconsistency...
	
	}

}
