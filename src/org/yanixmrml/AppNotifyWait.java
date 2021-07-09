package org.yanixmrml;

public class AppNotifyWait {
	
	public volatile static int balance = 0;
	
	
	public void withdraw(int amount) {
		synchronized(this) {
			if(balance<=0) {
				try {
					wait(6000); //wait for the notify, enter waiting phase
					System.out.println("Waiting for balance update");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		balance = balance - amount;
		System.out.println("Withdrawal successful, current balance is " + balance);
	}
	
	public void deposit(int amount) {
		System.out.println("We are depositing...");
		balance += amount;
		synchronized(this) {
			notifyAll();
			//Release the lock on all wait method	
			//notify only unlock 1 wait method
			//The thread with the longest time of waiting and or highest priority will be released
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppNotifyWait app = new AppNotifyWait();
		
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				app.withdraw(1000);
			}
			
		});
		thread1.setName("Thread1");
		thread1.start();
		
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				app.deposit(4000);
			}
		});
		thread2.setName("Thread2");
		thread2.start();
	}

}
