package com.core.thread.synchronization;

/*
 * Volatile Keyword Example
 */

import java.util.Scanner;

class ThreadProcess extends Thread {

	private volatile boolean flag = true;

	@Override
	public void run() {

		while (flag) {
			System.out.println("Hello");
		}

	}
	
	public void shutdown(){
		flag = false;
		System.out.println("Thread Interrupted by other Thread");
		
	}

}

public class ThreadSync1 {

	public static void main(String args[]){
		ThreadProcess thread1 = new ThreadProcess();
		thread1.start();
		
		Scanner in = new Scanner(System.in);
		
		in.nextLine();
		
		thread1.shutdown();
		
		
		
	}
	
	
	
	

}
