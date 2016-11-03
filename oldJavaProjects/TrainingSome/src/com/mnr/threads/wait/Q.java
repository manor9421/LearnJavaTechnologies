package com.mnr.threads.wait;

public class Q {

	int n;
	boolean valueSet = false;
	
	synchronized int get(){
		while(!valueSet)
			try{
				wait();
			}catch(InterruptedException e){
				System.out.println("exception!!!");
			}
		
		System.out.println("Get: " + n);
		valueSet = false;
		notify();
		return n;
	}
	
	synchronized void put(int n){
		while(valueSet)
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Exception");
			}
		
		this.n = n;
		valueSet = true;
		System.out.println("Sended: " + n);
		notify();
	}
	
}
