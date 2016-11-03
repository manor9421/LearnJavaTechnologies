package com.mnr.threads.wait;

public class Main {

	public static void main(String[] args) {
		
		Q q = new Q();
		new Producer(q);
		new Consumer(q);
		
		System.out.println("Press Ctrl+C to stop this");
		
	}

}
