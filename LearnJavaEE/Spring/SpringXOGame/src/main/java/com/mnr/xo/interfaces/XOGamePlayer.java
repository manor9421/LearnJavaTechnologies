package com.mnr.xo.interfaces;

import com.mnr.xo.model.PlayerSymbol;

public interface XOGamePlayer {
	
	public XOGamePlayer newPlayer();
	
	public PlayerSymbol getPs();

	public void setPs(PlayerSymbol ps);

	public String getName();

	public void setName(String name);
	
}
