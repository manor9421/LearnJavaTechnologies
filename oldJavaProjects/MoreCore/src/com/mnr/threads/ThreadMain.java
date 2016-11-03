package com.mnr.threads;

public class ThreadMain {

	public static void main(String[] args) {
		
		/*MyR t1 = new MyR();
		
		MyR t2 = new MyR();
		MyR t3 = new MyR();
		MyR t4 = new MyR();
		MyR t5 = new MyR();
		int t1Priority = t1.thread.getPriority();
		
		// are threads alive?
		System.out.println(	t1.thread.isAlive() + " " +
							t2.thread.isAlive() + " " +
							t3.thread.isAlive() + " " +
							t4.thread.isAlive() + " " +
							t5.thread.isAlive()
		);
		
		try {
			// wait for ending of all threads
			t1.thread.join();
			t2.thread.join();
			t3.thread.join();
			t4.thread.join();
			t5.thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(	t1.thread.isAlive() + " " +
				t2.thread.isAlive() + " " +
				t3.thread.isAlive() + " " +
				t4.thread.isAlive() + " " +
				t5.thread.isAlive()
		);
		
		System.out.println("End of all");
		
		System.out.println(t1Priority);
		*/
		
		Callme c = new Callme();
		MyT t1 = new MyT(c, "Hello");
		MyT t2 = new MyT(c, "Welcome");
		MyT t3 = new MyT(c, "Here");
		
		try{
			t1.thread.join();
			t2.thread.join();
			t3.thread.join();
			
		}catch (InterruptedException e) {
			System.out.println("join() exception");
		}
		
		
		
		
	}

}
