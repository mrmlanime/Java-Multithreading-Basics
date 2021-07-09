package org.yanixmrml;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockQueueConsumer implements Runnable{

	private ArrayBlockingQueue<Integer> queue;
	
	
	public BlockQueueConsumer(ArrayBlockingQueue<Integer> queue) {
		super();
		this.queue = queue;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(1000);
				queue.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BlockQueueThreadApp.counter--;
			System.out.println("Value removed in the queue : " + BlockQueueThreadApp.counter);
		}
	}
	

}
