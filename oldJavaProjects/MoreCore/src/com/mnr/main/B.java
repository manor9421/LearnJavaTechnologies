package com.mnr.makesome;

public class B extends A{

	int a;
	int d;
	
	public B(int a, int b, int c, int d) {
		
		super(a, b, c);
		super.c=44;
		this.a = a+1441;
		this.d = d;
		System.out.println("made B");
		
	}
	
	public void showShit(){
		System.out.println(super.a+"   "+this.a);
	}
	
	public void showShit(int q){
		System.out.println("q="+q+"||"+super.a+"   "+this.a);
	}
	/*
	public void a(){}
	public void a(int a){}
	public void a(String a){}
	*/
	
}
