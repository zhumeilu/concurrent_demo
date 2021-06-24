package com.zml.interrupted;

/**
 * @author: maylor
 * @date: 2021/5/18 15:54
 * @description:
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {
		MyThread myThread = new MyThread();
		myThread.start();
		Thread.sleep(10);
		myThread.interrupt();
		Thread.sleep(100);
		System.exit(0);
	}
}
