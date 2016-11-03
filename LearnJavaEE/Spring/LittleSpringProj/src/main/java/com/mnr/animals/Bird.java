package com.mnr.animals;

import com.mnr.interfaces.Flyable;

public class Bird implements Flyable{

	private String name;
	private int legCount;
	private boolean canFly;
	
	public Bird(){
	}
	
	public Bird(String name, int legCount, boolean canFly) {
		super();
		this.name = name;
		this.legCount = legCount;
		this.canFly = canFly;
	}

	@Override
	public void fly() {
		if(canFly){
			System.out.println("Bird fly");
		}else{
			System.out.println("Bird walk");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLegCount() {
		return legCount;
	}

	public void setLegCount(int legCount) {
		this.legCount = legCount;
	}

	public boolean isCanFly() {
		return canFly;
	}

	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
	}
	
	public void birdInit(){
		System.out.println("Born");
	}
	public void birdDestroy(){
		System.out.println("Bye");
	}
	

}
