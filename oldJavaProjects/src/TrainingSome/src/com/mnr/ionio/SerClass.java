package com.mnr.ionio;

import java.io.Serializable;

public class SerClass implements Serializable{

	int length;
	String name;
	
	public SerClass(int length, String name) {
		super();
		this.length = length;
		this.name = name;
	}
	
}
