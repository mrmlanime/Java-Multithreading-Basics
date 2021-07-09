package org.yanixmrml;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockQueueThreadApp {

	public static int counter = 0;
	
	public static void main(String args[]) {
		ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
		BlockQueueProducer  producer = new BlockQueueProducer(queue);
		Thread producerThread = new Thread(producer);
		producerThread.start();
		
		BlockQueueConsumer consumer = new BlockQueueConsumer(queue);
		Thread consumerThread = new Thread(consumer);
		consumerThread.start();
		
		//Good practice to have a thread safe selection
		
	}
	
}
