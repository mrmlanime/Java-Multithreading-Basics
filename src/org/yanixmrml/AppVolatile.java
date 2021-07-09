package org.yanixmrml;

public class AppVolatile {
	
	volatile public static int flag = 0;
	//volatile limited to variable, thread based on variable, it must not be cached so it can be updated
	
	public static void main(String args[]) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while(true) {
					if(flag==0) {
						System.out.println("Running");
					}else {
						break;
					}
				}
			}
			
		}).start();
	
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				AppVolatile.flag = 1;
				System.out.println("Flag is updated....");
			}
				
		}).start();
	
	}
		
	
	
	

}
