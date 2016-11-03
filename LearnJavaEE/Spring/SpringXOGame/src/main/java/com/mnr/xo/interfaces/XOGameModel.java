package com.mnr.xo.interfaces;

import com.mnr.xo.model.PlayerSymbol;

public interface XOGameModel {
	public PlayerSymbol isWinner();
	
	public boolean haveEmptyFields();
	
	public XOGameField[][] getFieldArray();


	public void setFieldArray(XOGameField[][] fieldArray);


	public void setGameField(int i,int j,PlayerSymbol ps);
	
	public PlayerSymbol getGameFieldSymbol(int i,int j);
	
}
