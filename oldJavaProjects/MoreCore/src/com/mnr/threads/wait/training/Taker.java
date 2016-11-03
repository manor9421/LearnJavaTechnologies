package com.mnr.threads.wait.training;

public class Taker implements Runnable{

	MakeSome mS;
	public Taker(MakeSome m) {
		this.mS = m;
		new Thread(this, "Taker thread").start();
	}
	
	@Override
	public void run() {
		
		int i=0;
		while(i<100){
			/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			mS.sendSome();
			i++;
			
		}
		
	}
	
}
