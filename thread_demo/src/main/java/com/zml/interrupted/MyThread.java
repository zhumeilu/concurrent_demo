package com.zml.interrupted;

/**
 * @author: maylor
 * @date: 2021/5/18 15:54
 * @description:
 */
public class MyThread extends Thread {

	@Override public void run() {
		while (true) {
			boolean interrupted = isInterrupted();
			System.out.println("中断标记：" + interrupted);
		}
	}
}
