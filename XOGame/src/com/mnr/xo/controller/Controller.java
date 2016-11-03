package com.mnr.xo.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.mnr.xo.model.Game;
import com.mnr.xo.model.Player;
import com.mnr.xo.model.PlayerSymbol;
import com.mnr.xo.model.XOGameButton;
import com.mnr.xo.view.GameField;

public class Controller implements ActionListener{
	
	GameField gameField;
	Game game;
	Player player;
	Player comp;
	
	public Controller(GameField gameField, Game game, Player player) {
		super();
		this.gameField = gameField;
		this.game = game;
		this.player = player;
		comp = new Player( (player.getPs()==PlayerSymbol.X) ? PlayerSymbol.O : PlayerSymbol.X,"comp");
		
		addListeners();
	}
	
	public Player getPlayer() {
		return player;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//проверить кнопку
		int i = ( (XOGameButton) e.getSource() ).getI();
		int j = ( (XOGameButton) e.getSource() ).getJ();
		if(game.getGameFieldSymbol(i, j) == PlayerSymbol.EMPTY){
			PlayerSymbol ps = PlayerSymbol.X;
			// изменить массив модели
			game.setGameField(i, j, ps);
			// изменить текст кнопки
			gameField.changeButtonText(i, j, ps);
			// проверить на выигрыш
			checkWinner();
			compShoot();
			checkWinner();
			
		}
		
	}
	
	private void checkWinner(){
		PlayerSymbol winningSymbol = game.isWinner();
		if(winningSymbol != PlayerSymbol.EMPTY){
			if(winningSymbol == player.getPs()){
				gameField.informWinner(player.getName());
			}else{
				gameField.informWinner(comp.getName());
			}
		}
	}
	
	public void addListeners(){
		XOGameButton[][] buttonArray = gameField.getXOButoons();
		for(int i=0;i<buttonArray.length;i++){
			for(int j=0;j<buttonArray[i].length;j++){
				buttonArray[i][j].addActionListener(this);
			}
		}
	}
	
	public void compShoot(){
		if(game.haveEmptyFields()){
			Random rand = new Random();
			int i = rand.nextInt(3);
			int j = rand.nextInt(3);
			if(game.getGameFieldSymbol(i, j) == PlayerSymbol.EMPTY){
				game.setGameField(i, j, comp.getPs());
				gameField.changeButtonText(i, j, comp.getPs());
			}else{
				compShoot();
			}
		}
	}
	
	
}
