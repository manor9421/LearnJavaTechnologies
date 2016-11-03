package com.mnr.threads;

public class MyR implements Runnable{

	Thread thread;
	public MyR() {
		this.thread = new Thread(this, "Demo Thread");
		System.out.println("DemoThread started");
		thread.start();
	}
	
	@Override
	public void run() {
		for(int i=0; i<99; i++){
			System.out.println(thread.getId() + ": val=" + i);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Demo thread over. Id: " + thread.getId());
		
	}
	
}
