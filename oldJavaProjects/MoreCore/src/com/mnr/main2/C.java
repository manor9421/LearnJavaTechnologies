package com.mnr.main;

public class C implements A,B.Q{

	@Override
	public boolean qMeth(int a) {
		System.out.println("qmeth");
		
		return true;
	}
	
	//@Override
	public void meth1() {
		System.out.println("C->A");
	}
	
	public void m2(){
		System.out.println("C-m2");
	}
	
}
