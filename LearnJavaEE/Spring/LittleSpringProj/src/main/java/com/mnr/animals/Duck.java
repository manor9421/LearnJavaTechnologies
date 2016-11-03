package com.mnr.animals;

import com.mnr.interfaces.Flyable;
import com.mnr.interfaces.Swimable;

public class Duck implements Swimable,Flyable{

	@Override
	public void fly() {
		
		System.out.println("Duck fly");
		
	}

	@Override
	public void swim() {

		System.out.println("Duck swim");
		
	}

}
