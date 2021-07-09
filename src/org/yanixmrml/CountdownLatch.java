package org.yanixmrml;

import java.util.concurrent.CountDownLatch;

public class CountdownLatch extends Thread {

	private CountDownLatch latch;
	
	public CountdownLatch(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("Thread running with the thread name " + Thread.currentThread().getName());
		System.out.println("Thread execution completed");
		System.out.println(".............");
		latch.countDown(); //Meaning this instance of thread of the specific latch is deleted and now released
	}	
	
	
}

