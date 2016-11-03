package com.mnr.makesome;

public class AbsB extends AbsA implements Cloneable{

	int c;
	
	@Override
	void callme() {
		System.out.println("overrided meth");
	}
	
	@Override
	void callMe18() {
		
		System.out.println("overrrr"+c);
		
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	@Override
	protected void finalize() throws Throwable {
		
		super.finalize();
		
		System.out.println("Finalize");
		
	}
	
}
