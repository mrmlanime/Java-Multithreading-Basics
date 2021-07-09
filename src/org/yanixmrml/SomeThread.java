package org.yanixmrml;

public class SomeThread extends Thread{

	private String name;
	
	public SomeThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//super.run();
		System.out.println("Starting thread : " + name);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("End thread: " + name);
	}
	
}


