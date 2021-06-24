package com.zml.tool.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author: maylor
 * @date: 2021/6/1 20:45
 * @description:
 */
public class MyThread extends Thread{

	private final CountDownLatch latch;
	private final Random         random = new Random();

	public MyThread(String name, CountDownLatch latch) {
		super(name);
		this.latch = latch;
	}

	@Override public void run() {
		try {
			Thread.sleep(random.nextInt(2000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "运行结束");
		latch.countDown();
	}
}
