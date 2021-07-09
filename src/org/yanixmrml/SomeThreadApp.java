package org.yanixmrml;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SomeThreadApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		SomeThread thread1 = new SomeThread("Thread 1");
		SomeThread thread2 = new SomeThread("Thread 2");
		SomeThread thread3 = new SomeThread("Thread 3");
		SomeThread thread4 = new SomeThread("Thread 4");
		SomeThread thread5 = new SomeThread("Thread 5");
		
		executorService.execute(thread1);
		executorService.execute(thread2);
		executorService.execute(thread3);
		executorService.execute(thread4);
		executorService.execute(thread5);
		
		executorService.shutdown();
		
		
	}

}
