package com.mnr.threads.wait.training;

public class MakeSome {

	int n;
	boolean check = false;
	
	synchronized public void getSome(int n){
		while(check == true){
			try {
				System.out.println(Thread.currentThread().getName()+" is waiting");
				wait();// make current thread waiting
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.n = n;
		check = true;
		System.out.println("new n: " + n);
		notify();// notify thread which is waiting
		
	}
	
	synchronized public int sendSome(){
		while(check == false){
			try {
				System.out.println(Thread.currentThread().getName()+" is waiting");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("n in use: "+n);
		check = false;
		notify();
		return n;
		
	}
	
}
