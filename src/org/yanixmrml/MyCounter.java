package org.yanixmrml;

public class MyCounter extends Thread{
	
	private int threadNo;
	
	public MyCounter(int threadNo) {
		this.threadNo = threadNo;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		countMe();
	}
	
	public void countMe() {
		for(int i=1;i<10;i++) {
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("The value of i is : " + i + 
					" and thread number is " + threadNo);
		}
	}
	
}

