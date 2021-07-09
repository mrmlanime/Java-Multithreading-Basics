package org.yanixmrml;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockQueueProducer implements Runnable {

	private ArrayBlockingQueue<Integer> queue;

	public BlockQueueProducer(ArrayBlockingQueue<Integer> queue) {
		//super();
		this.queue = queue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(5000);
				queue.put(BlockQueueThreadApp.counter++);
				System.out.println("Value added in the queue" + BlockQueueThreadApp.counter);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
}
