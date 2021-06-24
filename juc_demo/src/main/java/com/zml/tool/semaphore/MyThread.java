package com.zml.tool.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @author: maylor
 * @date: 2021/6/1 20:42
 * @description:
 */
public class MyThread extends Thread {

	private final Semaphore semaphore;
	private final Random    random = new Random();

	public MyThread(String name, Semaphore semaphore) {
		super(name);
		this.semaphore = semaphore;
	}

	@Override public void run() {
		try {
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName() + " - 抢座成功，开始写作业");
			Thread.sleep(random.nextInt(1000));
			System.out.println(Thread.currentThread().getName() + " - 作业完成，腾出座位");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		semaphore.release();
	}
}