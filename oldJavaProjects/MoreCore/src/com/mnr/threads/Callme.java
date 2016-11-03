package com.mnr.threads;

public class Callme {

	synchronized void syncCallMe(String m){
		System.out.println("Called " + m);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end of " + m);
	}
	
	void callMe(String m){
		System.out.println("Called " + m);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end of " + m);
	}
	
	
}
