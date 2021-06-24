package com.zml.tool.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author: maylor
 * @date: 2021/6/1 20:43
 * @description: 基于AQS
 */
public class Demo {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(2);
		for (int i = 0; i < 5; i++) {
			new MyThread("学生-" + (i + 1), semaphore).start();
		}
	}
}
