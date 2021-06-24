package com.zml.tool.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author: maylor
 * @date: 2021/6/1 20:49
 * @description: CyclicBarrier基于ReentrantLock+Condition实现
 */
public class Demo {

	public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
		CyclicBarrier barrier = new CyclicBarrier(5);
		for (int i = 0; i < 5; i++) {
			new MyThread("线程-" + (i + 1), barrier).start();
		}
	}
}
