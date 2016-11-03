package com.mnr.threads;

public class MyT implements Runnable {
	
	Thread thread;
	String s;
	Callme t;
	
	public MyT(Callme t, String s) {
		this.t = t;
		this.s = s;
		this.thread = new Thread(this, "Demo Thread");
		
		System.out.println("DemoThread started");
		thread.start();
	}
	
	@Override
	public void run() {
		
		//t.syncCallMe(s);
		
		//synchronize non-synchronized method
		synchronized (t) {// synchronized by Callme class object
			t.callMe(s);
		}
		
		
	}
	
}
