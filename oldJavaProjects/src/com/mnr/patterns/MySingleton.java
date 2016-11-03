package com.mnr.patterns;

public class MySingleton {

	
	
	
	/** My Best one */
	private volatile MySingleton instance;
	
	private MySingleton(){}
	
	public MySingleton getInstance(){
		
		if(instance == null){ // 1
			synchronized (MySingleton.class) {
				if(instance == null){// 2
					instance = new MySingleton();// create instance
				}// end of 2 if
			}
		}// end of 1 if
		return instance;
		
	}
	
	
	
	/*
	// static block called before we call constructor
	private static MySingleton instance = null;
	
	static{
		instance = new MySingleton();
	}
	
	private MySingleton(){}
	
	public static MySingleton getInstance(){
		return instance;
	}
	*/
	
	/*
	private static MySingleton instance;
	
	
	private MySingleton(){}
	
	public static synchronized MySingleton getInstance(){
		if(instance == null){
			instance = new MySingleton();
		}
		return instance;
	}
	*/
	
	
	/*
	private static MySingleton instance = new MySingleton();
	
	private MySingleton(){}
	
	public static MySingleton getInstance(){
		return instance;
	}
	*/
	
	
}
