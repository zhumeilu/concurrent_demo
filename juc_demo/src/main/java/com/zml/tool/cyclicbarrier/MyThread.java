package com.zml.tool.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author: maylor
 * @date: 2021/6/1 20:48
 * @description:
 */
public class MyThread extends Thread {

	private final CyclicBarrier barrier;
	private final Random        random = new Random();

	public MyThread(String name, CyclicBarrier barrier) {
		super(name);
		this.barrier = barrier;
	}

	@Override public void run() {
		try {
			Thread.sleep(random.nextInt(2000));
			System.out.println(Thread.currentThread().getName() + " - 已经到 达公司");
			barrier.await();
			Thread.sleep(random.nextInt(2000));
			System.out.println(Thread.currentThread().getName() + " - 已经笔 试结束");
			barrier.await();
			Thread.sleep(random.nextInt(2000));
			System.out.println(Thread.currentThread().getName() + " - 已经面 试结束");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		super.run();
	}
}
