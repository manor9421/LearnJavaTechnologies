package com.mnr.xo.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.mnr.xo.interfaces.XOGameField;

@Component
public class Field implements XOGameField{

	private PlayerSymbol symbol;
	
	public Field() {
	}

	public Field(PlayerSymbol symbol) {
		this.symbol = symbol;
	}
	
	@Override
	public PlayerSymbol getSymbol() {
		return symbol;
	}
	
	@Override
	public void setSymbol(PlayerSymbol symbol) {
		this.symbol = symbol;
	}
	
	@Override
	@Bean("fieldArray")
	public XOGameField[][] createEmptySymbArray(){
		Field[][] nF = new Field[3][3];
		for(int i=0;i<nF.length;i++){
			for(int j=0;j<nF[i].length;j++){
				nF[i][j] = new Field(PlayerSymbol.EMPTY);
			}
		}
		
		return nF; 
	}
	
}
