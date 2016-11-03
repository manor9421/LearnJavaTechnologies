package com.mnr.threads.wait.training;

public class Giver implements Runnable{

	MakeSome mS;
	
	public Giver(MakeSome m) {
		this.mS = m;
		new Thread(this, "Giver thread").start();
	}
	
	@Override
	public void run() {
		
		int i=0;
		while(i<100){
			
			mS.getSome(++i);
			
		}
		
	}
	
}
