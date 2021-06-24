package com.zml;

/**
 * @author: maylor
 * @date: 2021/5/18 15:31
 * @description:
 */
public class MyQueue {

	private String[] data     = new String[10];
	//消费的索引
	private int      getIndex = 0;
	//生产的索引
	private int      putIndex = 0;
	//队列内有多少个元素
	private int      size     = 0;

	public synchronized void put(String element) {
		//如果队列满了，则等待
		if (size == data.length) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		data[putIndex] = element;
		++putIndex;
		if (putIndex == data.length)
			putIndex = 0;
		++size;
		notify();
	}

	public synchronized String get() {
		//如果队列空了则等待
		if (size == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		String result = data[getIndex];
		++getIndex;
		if (getIndex == data.length)
			getIndex = 0;
		--size;
		notify();
		return result;
	}
}
