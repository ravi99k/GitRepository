package com.core.thread.synchronization;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * Intrinsic lock is a lock acquired by thread when synchronized keyword is used.
 * Synchronized Blocks
 * 	if a method is synchronized the intrinsic lock acquired by the thread, during this time frame only one thread 
 * 	can execute whole class. Multiple threads cannot execute multiple methods as the lock of the class is acquired by
 * 	the thread. It is ideal but takes more time for the execution.
 * 	To come across this situation we need to do synchronized block with object lock technique below 
 *
 */

public class ThreadSync3 {

	List<Integer> list1 = new ArrayList<>();
	List<Integer> list2 = new ArrayList<>();

	Object obj1 = new Object();
	Object obj2 = new Object();

	static Random random = new Random();

	public void processList1() {
		synchronized (obj1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list1.add(random.nextInt(100));
		}
	}

	public void processList2() {
		synchronized (obj2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list2.add(random.nextInt(100));
		}

	}

	public void executeProcess() {
		for (int i = 0; i < 1000; i++) {
			processList1();
			processList2();
		}
	}

	public static void main(String args[]) {

		System.out.println("Thread execution Starting");

		ThreadSync3 sync = new ThreadSync3();

		long start = System.currentTimeMillis();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				sync.executeProcess();

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				sync.executeProcess();

			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();

		System.out.println("total Time=" + (end - start));
		System.out.println("list1=" + sync.list1.size() + " List2=" + sync.list2.size());

	}

}
