package com.core.thread;


class Runner1 implements Runnable{

	@Override
	public void run() {
		for(int i= 0; i<10; i++)
			System.out.println("hello"+i);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

public class DemoThread2 {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runner1());
		Thread t2 = new Thread(new Runner1());
		
		t1.start();
		t2.start();
		

	}

}
