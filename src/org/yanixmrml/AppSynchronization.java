package org.yanixmrml;

public class AppSynchronization {

	public static int counter = 0;
	
	public static void main(String args[]) throws InterruptedException {
		
		/*Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=1;i<=1000;i++) {
					AppSynchronization.counter++;
				}
				System.out.println("The loop in thread 1 is over");
			}
			
			
		});
		
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=1;i<=1000;i++) {
					AppSynchronization.counter++;
				}
				System.out.println("The thread 2 is over");
			}
			
			
		});
		
		thread1.start();
		thread2.start();
		//Thread.sleep(2000);
		System.out.println("Counter : " + counter);
		
		*/
		
		Bracket bracket1 = new Bracket();
		//Bracket bracket2 = new Bracket();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				long startTime = System.currentTimeMillis();
				for(int i=0;i<5;i++) {
					bracket1.generate();
				}
				long endTime = System.currentTimeMillis();
				System.out.println("Time 1 is " + (endTime - startTime));	
			}
		}).start();
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				long startTime = System.currentTimeMillis();
				for(int i=0;i<5;i++) {
					bracket1.generate();
				}
				long endTime = System.currentTimeMillis();
				System.out.println("Time 2 is " + (endTime - startTime));	
			}
				
		}).start();
		
	}
	
}
