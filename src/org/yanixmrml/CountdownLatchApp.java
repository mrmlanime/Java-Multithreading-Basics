package org.yanixmrml;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchApp {

	public static void main(String args[]) {
		CountDownLatch latch = new CountDownLatch(4); // Unlock 4 times and release the statement latch.await()
		CountdownLatch t1 = new CountdownLatch(latch);
		CountdownLatch t2 = new CountdownLatch(latch);
		CountdownLatch t3 = new CountdownLatch(latch);
		CountdownLatch t4 = new CountdownLatch(latch);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		try {
			latch.await(); // if this was executed in the main method, the main methdod will be forced
							//to wait until lock is released.. Locking the main thread actually and continuously waiting... 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main thread is running....");
	}
}
