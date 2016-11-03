package com.mnr.patterns;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
//import javax.ejb.Singleton;

import javax.annotation.PostConstruct;

//@Singleton
public class JEESingletone {

	private Map<Integer, String> myS;
	
	@PostConstruct
	public void start(){
		Logger.getLogger("MyLogger").info("Started");
		myS = new HashMap<>();
	}
	
	public void addUser(Integer id, String name){
		myS.put(id, name);
	}
	
	public String getName(Integer id){
		return myS.get(id);
	}
	
	
}
