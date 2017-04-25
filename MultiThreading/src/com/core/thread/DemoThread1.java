package com.core.thread;

class Runner extends Thread {

	public void run() {

		for (int i = 0; i < 10; i++)
			System.out.println("Hello" + i);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}

public class DemoThread1 {

	public static void main(String args[]) {
		Runner thread1 = new Runner();
		Runner thread2 = new Runner();

		thread1.start();
		thread2.start();
	}

}
