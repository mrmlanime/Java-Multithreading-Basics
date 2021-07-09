package org.yanixmrml;

public class App {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*
		MyCounter counter1 = new MyCounter(1);
		MyCounter counter2 = new MyCounter(2);
		long startTime = System.currentTimeMillis();
		counter1.start(); //Run should be called by JVM
		System.out.println(" -------------------------- ");
		Thread.sleep(4505);
		counter2.start(); //Run should be called by JVM
		long endTime = System.currentTimeMillis();
		System.out.println("Total time required is : " + (endTime - startTime));
		*/
		Thread thread1 = new Thread(new CounterRunnable(1));
		Thread thread2 = new Thread(new CounterRunnable(2));
		thread1.start();
		System.out.println(" -------------------- ");
		thread2.start();
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<10;i++) {
					System.out.println("N " + i);
				}
			}
			
		}).start();
	}	

}
