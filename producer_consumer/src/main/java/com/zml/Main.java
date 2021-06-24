package com.zml;

/**
 * @author: maylor
 * @date: 2021/5/18 15:33
 * @description:
 */
public class Main {

	public static void main(String[] args) {
		MyQueue myQueue = new MyQueue();
		ProducerThread producerThread = new ProducerThread(myQueue);
		ConsumerThread consumerThread = new ConsumerThread(myQueue);
		producerThread.start();
		consumerThread.start();
	}
}
