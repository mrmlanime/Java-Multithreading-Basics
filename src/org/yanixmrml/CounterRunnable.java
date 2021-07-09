package org.yanixmrml;

import java.util.Random;

public class CounterRunnable implements Runnable {

	private int threadNo;

	public CounterRunnable(int threadNo) {
		this.threadNo = threadNo;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		for(int i=1;i<10;i++) {
			try {
				Thread.sleep(rand.nextInt(100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("The value of i is : " + i + 
					" and thread number is " + threadNo);
		}
	}
	
}
