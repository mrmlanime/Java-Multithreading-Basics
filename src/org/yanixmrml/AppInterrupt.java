package org.yanixmrml;

public class AppInterrupt {
	
	private volatile static int balance = 0;

	public void withdraw(int amount) {
		synchronized(this) {
			if(balance<=0 || balance < amount) {
				try {
					System.out.println("Waiting for balance update");
					wait(6000); //wait for the notify, enter waiting phase
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					balance = balance - amount;
					System.out.println("Withdrawal successful, current balance is " + balance);
					System.out.println("Thread got interrupted");
				}
			}else {
				System.out.println("Withdrawing amount...");
			}
		}
	}
	
	public void deposit(int amount) {
		System.out.println("Depositing amount...");
		balance -= amount;
	}
	
	public static void main(String args[]) {
		AppInterrupt app = new AppInterrupt();
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//while(true)
				app.withdraw(1000);
			}
		});
		thread1.start();
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(3000);
					app.deposit(2000);
					thread1.interrupt();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
		});
		thread2.start();
	}
	
	

}
