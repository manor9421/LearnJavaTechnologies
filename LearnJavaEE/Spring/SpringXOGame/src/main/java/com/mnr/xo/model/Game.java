package com.mnr.xo.model;

import com.mnr.xo.interfaces.XOGameField;
import com.mnr.xo.interfaces.XOGameModel;

public class Game implements XOGameModel{

	private XOGameField[][] fieldArray;
	
	public Game(){
	}

	public Game(XOGameField[][] fieldArray) {
		super();
		this.fieldArray = fieldArray;
	}

	@Override
	public XOGameField[][] getFieldArray() {
		return fieldArray;
	}

	@Override
	public void setFieldArray(XOGameField[][] fieldArray) {
		this.fieldArray = fieldArray;
	}

	@Override
	public void setGameField(int i,int j,PlayerSymbol ps){
		fieldArray[i][j].setSymbol(ps);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.mnr.xo.interfaces.XOGameModel#getGameFieldSymbol(int, int)
	 * return symbol of cell with taken coordinates
	 */
	@Override
	public PlayerSymbol getGameFieldSymbol(int i,int j){
		return fieldArray[i][j].getSymbol();
	}
	
	/*
	 * return winning symbol
	 */
	@Override
	public PlayerSymbol isWinner(){
		if( (fieldArray[0][0].getSymbol() == PlayerSymbol.X && fieldArray[0][1].getSymbol() == PlayerSymbol.X && fieldArray[0][2].getSymbol() == PlayerSymbol.X) ||
				(fieldArray[1][0].getSymbol() == PlayerSymbol.X && fieldArray[1][1].getSymbol() == PlayerSymbol.X && fieldArray[1][2].getSymbol() == PlayerSymbol.X) ||
				(fieldArray[2][0].getSymbol() == PlayerSymbol.X && fieldArray[2][1].getSymbol() == PlayerSymbol.X && fieldArray[2][2].getSymbol() == PlayerSymbol.X) ||

				(fieldArray[0][0].getSymbol() == PlayerSymbol.X && fieldArray[1][0].getSymbol() == PlayerSymbol.X && fieldArray[2][0].getSymbol() == PlayerSymbol.X) ||
				(fieldArray[0][1].getSymbol() == PlayerSymbol.X && fieldArray[1][1].getSymbol() == PlayerSymbol.X && fieldArray[2][1].getSymbol() == PlayerSymbol.X) ||
				(fieldArray[0][2].getSymbol() == PlayerSymbol.X && fieldArray[1][2].getSymbol() == PlayerSymbol.X && fieldArray[2][2].getSymbol() == PlayerSymbol.X) ||

				(fieldArray[0][0].getSymbol() == PlayerSymbol.X && fieldArray[1][1].getSymbol() == PlayerSymbol.X && fieldArray[2][2].getSymbol() == PlayerSymbol.X) ||
				(fieldArray[0][2].getSymbol() == PlayerSymbol.X && fieldArray[1][1].getSymbol() == PlayerSymbol.X && fieldArray[2][0].getSymbol() == PlayerSymbol.X) ){
				return PlayerSymbol.X;
			}else if( (fieldArray[0][0].getSymbol() == PlayerSymbol.O && fieldArray[0][1].getSymbol() == PlayerSymbol.O && fieldArray[0][2].getSymbol() == PlayerSymbol.O) ||
					(fieldArray[1][0].getSymbol() == PlayerSymbol.O && fieldArray[1][1].getSymbol() == PlayerSymbol.O && fieldArray[1][2].getSymbol() == PlayerSymbol.O) ||
					(fieldArray[2][0].getSymbol() == PlayerSymbol.O && fieldArray[2][1].getSymbol() == PlayerSymbol.O && fieldArray[2][2].getSymbol() == PlayerSymbol.O) ||

					(fieldArray[0][0].getSymbol() == PlayerSymbol.O && fieldArray[1][0].getSymbol() == PlayerSymbol.O && fieldArray[2][0].getSymbol() == PlayerSymbol.O) ||
					(fieldArray[0][1].getSymbol() == PlayerSymbol.O && fieldArray[1][1].getSymbol() == PlayerSymbol.O && fieldArray[2][1].getSymbol() == PlayerSymbol.O) ||
					(fieldArray[0][2].getSymbol() == PlayerSymbol.O && fieldArray[1][2].getSymbol() == PlayerSymbol.O && fieldArray[2][2].getSymbol() == PlayerSymbol.O) ||

					(fieldArray[0][0].getSymbol() == PlayerSymbol.O && fieldArray[1][1].getSymbol() == PlayerSymbol.O && fieldArray[2][2].getSymbol() == PlayerSymbol.O) ||
					(fieldArray[0][2].getSymbol() == PlayerSymbol.O && fieldArray[1][1].getSymbol() == PlayerSymbol.O && fieldArray[2][0].getSymbol() == PlayerSymbol.O) ){
				return PlayerSymbol.O;
		}
		
		return PlayerSymbol.EMPTY;
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.mnr.xo.interfaces.XOGameModel#haveEmptyFields()
	 * check do we have at least 1 field with EMPTY symbol
	 */
	@Override
	public boolean haveEmptyFields(){
		for(int i=0;i<fieldArray.length;i++){
			for(int j=0;j<fieldArray[i].length;j++){
				if(fieldArray[i][j].getSymbol() == PlayerSymbol.EMPTY)
					return true;
			}
		}
		return false;
		
	}
	
}
