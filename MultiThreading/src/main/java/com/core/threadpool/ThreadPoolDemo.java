package com.core.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Process implements Runnable {

	private int i;

	public Process(int i) {
		this.i = i;
	}

	@Override
	public void run() {
		System.out.println("Task started" + i);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Task Completed" + i);

	}

}

public class ThreadPoolDemo {

	public static void main(String args[]) {
		ExecutorService executor = Executors.newFixedThreadPool(2);

		for (int i = 0; i < 5; i++)
			executor.submit(new Process(i));

		executor.shutdown();

		System.out.println("All Task submitted");

		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("All Task completed");

	}

}
