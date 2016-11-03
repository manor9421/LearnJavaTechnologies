package com.mnr.makesome;

public class T {

	Integer aInteger;
	
	public T(Integer a) {
		this.aInteger = a;
		System.out.println("aInteger = " + aInteger);
	}
	
	@Override
	protected void finalize() throws Throwable {
		
		super.finalize();
		
		aInteger = null;
		
		System.out.println("finalize! aInteger now = " + aInteger +
				"\nT object finalized");
		
	}
	
}
