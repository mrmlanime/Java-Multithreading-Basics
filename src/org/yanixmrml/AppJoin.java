package org.yanixmrml;

public class AppJoin {
	
	public int counter = 0;
	
	public static void main(String args[]) {
		AppJoin app = new AppJoin();

		long startTime, endTime;
		startTime = System.currentTimeMillis();
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int i=0;i<100000;i++) {
					app.counter++;
				}
			}
		});
		/*try {
			thread1.join(); // Join with the main thread -> Main Method will wait for the thread1 to execute first
			//Thread.sleep(1); //thread1 will be part of the main thread, thread1 and main thread will join, 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The value of counter : " + app.counter);
		*/
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					thread1.join(2000);
					//It means thread2 will wait for thread1 to finish
					//It meas that thread2 will lock/wait at 2000 milliseconds only and it the times out it will simultaneoulsy execuite with main thread
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int i=0;i<100000;i++) {
					app.counter++;
				}
			}
		});
		thread1.start();
		thread2.start();
		try {
			thread2.join();
			//Main thread will wait for thread2 to finish
			//Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		endTime = System.currentTimeMillis();
		System.out.println("The value of counter : " + app.counter);
		System.out.println("Time : " + (endTime - startTime));
		
	}

}
