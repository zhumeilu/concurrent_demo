package com.zml.interrupted;

/**
 * @author: maylor
 * @date: 2021/5/18 17:28
 * @description:
 */
public class MyThread3 extends Thread {

	@Override public void run() {

		try {
			sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("被中断================》");
			e.printStackTrace();
		}
		System.out.println("子线程结束================》");
	}

	public static void main(String[] args) throws InterruptedException{
		MyThread3 thread3 = new MyThread3();
		thread3.start();
		thread3.interrupt();
		Thread.sleep(1000);
		System.out.println("=========主线程结束");
	}
}
