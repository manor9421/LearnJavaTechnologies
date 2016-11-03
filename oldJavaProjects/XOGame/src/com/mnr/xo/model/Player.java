package com.mnr.xo.model;

public class Player{
	
	private PlayerSymbol ps;
	String name;

	public Player(PlayerSymbol ps,String name) {
		super();
		this.ps = ps;
		this.name = name;
	}

	public PlayerSymbol getPs() {
		return ps;
	}

	public void setPs(PlayerSymbol ps) {
		this.ps = ps;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
