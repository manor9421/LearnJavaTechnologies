package com.mnr.xo.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.mnr.xo.interfaces.XOGamePlayer;

@Component
@Lazy
public class Player implements XOGamePlayer{
	
	private PlayerSymbol ps;
	String name;
	
	public Player(){
		System.out.println("bbbb");
	}

	public Player(PlayerSymbol ps,String name){
		super();
		this.ps = ps;
		this.name = name;
	}
	
	@Override
	@Bean("newPlayer")
	public XOGamePlayer newPlayer(){
		return new Player(PlayerSymbol.X, "Sergey");
	}

	@Override
	public PlayerSymbol getPs() {
		return ps;
	}

	@Override
	public void setPs(PlayerSymbol ps) {
		this.ps = ps;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}
