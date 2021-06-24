package com.zml.interrupted;

/**
 * @author: maylor
 * @date: 2021/5/18 17:28
 * @description:
 */
public class Main2 {

	public static void main(String[] args) throws InterruptedException {
		MyThread2 myThread = new MyThread2();
		myThread.start();
		Thread.sleep(10);
		myThread.interrupt();
		Thread.sleep(7);
		System.out.println("main中断状态检查-1：" + myThread.isInterrupted());
		System.out.println("main中断状态检查-2：" + myThread.isInterrupted());
	}
}
