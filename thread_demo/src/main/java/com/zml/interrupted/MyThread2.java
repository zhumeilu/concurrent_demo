package com.zml.interrupted;

/**
 * @author: maylor
 * @date: 2021/5/18 17:28
 * @description:
 */
public class MyThread2 extends Thread {

	@Override public void run() {
		int i = 0;
		while (true) {
			boolean interrupted = isInterrupted();
			System.out.println("中断标记：" + interrupted);
			++i;
			if (i > 20000) { // 检查并重置中断标志。
				boolean interrupted1 = Thread.interrupted();
				System.out.println("重置中断状态：" + interrupted1);
				interrupted1 = Thread.interrupted();
				System.out.println("重置中断状态：" + interrupted1);
				interrupted = isInterrupted();
				System.out.println("中断标记：" + interrupted);
				break;
			}
		}
	}
}
