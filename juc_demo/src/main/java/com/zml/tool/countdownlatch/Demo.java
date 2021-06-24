package com.zml.tool.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author: maylor
 * @date: 2021/6/1 20:45
 * @description: 基于AQS实现
 */
public class Demo {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(5);
		new MyThread("线程1", latch).start();
		new MyThread("线程2", latch).start();
		new MyThread("线程3", latch).start();
		new MyThread("线程4", latch).start();
		 new MyThread("线程5", latch).start();
		// 当前线程等待
		latch.await();
		System.out.println("程序运行结束");
	}
}
