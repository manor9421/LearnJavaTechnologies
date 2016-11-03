package com.mnr.xo.interfaces;

import com.mnr.xo.model.PlayerSymbol;

public interface XOGameField {

	public PlayerSymbol getSymbol();

	public void setSymbol(PlayerSymbol symbol);
	
	public XOGameField[][] createEmptySymbArray();
	
}
