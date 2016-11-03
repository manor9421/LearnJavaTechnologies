package com.mnr.xo.interfaces;

import com.mnr.xo.model.PlayerSymbol;

public interface XOGameViewField {
	
	public void drawField();
	
	public void informWinner(String name);
	
	public void changeButtonText(int i,int j,PlayerSymbol symbol);
	
	public XOGameButton[][] getJb();

	public void setJb(XOGameButton[][] jb);
}
