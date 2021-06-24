package com.zml.interrupted;

/**
 * @author: maylor
 * @date: 2021/5/18 17:57
 * @description:
 */
public class MyResource {
	//需要获取锁之后才能中断
	public synchronized void push(){
		System.out.println("--------------push---------------");
		try {
			wait();
			System.out.println("--------------push.wait.over---------------");
		} catch (InterruptedException e) {
			System.out.println("--------------push.wait.interrupted---------------");
		}
		System.out.println("--------------push.over---------------");
	}

	public synchronized void pop(){
		System.out.println("--------------pop---------------");
//			notify();
//		System.out.println("--------------pop.notify---------------");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("--------------pop.over---------------");
	}

	public static void main(String[] args) throws InterruptedException {
		MyResource resource = new MyResource();
		Thread t1 = new Thread(new Runnable() {

			@Override public void run() {
				resource.push();
			}
		});
		t1.start();
		Thread.sleep(10);
		Thread t2 = new Thread(new Runnable() {

			@Override public void run() {
				resource.pop();
			}
		});
		t2.start();
		Thread.sleep(100);
		t1.interrupt();
		Thread.sleep(1000);
		System.out.println("--------------main.over---------------");
	}
}
