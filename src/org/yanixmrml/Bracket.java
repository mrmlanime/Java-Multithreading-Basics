package org.yanixmrml;

public class Bracket {

	private Object lock = "lock"; //Recommended for security 
	
	public void generate() {
		//Note synchronized means execute the method/code sequentially and only 
		//refers to the instance of the object. Thus making the output of the method consistent
		//If 2 different objects is running then there is no consistent output
		// It means the execution must not be skipped and must be done or implemented fully
		synchronized (lock){	
			for(int i=0;i<10;i++)
			{
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(i<5) {
					System.out.print("[");
				}else {
					System.out.print("]");
				}
			}
		}
		System.out.println();
		for(int j=0;j<=10;j++) {
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/***
	 * 
	 * Synchronized method approach 
	 * Time required: 5908
	 * 
	 * Synchronized block approach
	 * Time required: 4052
	 * 
	 * Recommend to use synchronized block if you only specific code is synchronized
	 * 
	 */
	
}
