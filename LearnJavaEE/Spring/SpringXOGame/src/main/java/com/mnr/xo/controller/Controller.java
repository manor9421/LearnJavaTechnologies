package com.mnr.xo.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import com.mnr.xo.interfaces.XOGameButton;
import com.mnr.xo.interfaces.XOGameModel;
import com.mnr.xo.interfaces.XOGamePlayer;
import com.mnr.xo.interfaces.XOGameViewField;
import com.mnr.xo.model.Player;
import com.mnr.xo.model.PlayerSymbol;

public class Controller implements ActionListener{
	
	XOGameViewField gameField;
	XOGameModel game;
	XOGamePlayer player;
	XOGamePlayer comp;
	
	public Controller(){
	}
	
	/*
	 * constructor
	 */
	public Controller(XOGameViewField gameField, XOGameModel game, XOGamePlayer player) {
		super();
		this.gameField = gameField;
		this.game = game;
		this.player = player;
		comp = new Player( (player.getPs()==PlayerSymbol.X) ? PlayerSymbol.O : PlayerSymbol.X,"comp");
	}
	
	public XOGamePlayer getPlayer() {
		return player;
	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * create an action listener for XOGameButton
	 * cheack winner after each user "click" and make computer one after that
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//проверить кнопку
		int i = ( (XOGameButton) e.getSource() ).getI();
		int j = ( (XOGameButton) e.getSource() ).getJ();
		//System.out.println("22");
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
	
	/*
	 * check winner of the game. If we have a winner - causes GameField congratulation method with winner name parameter. else - none
	 */
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
	
	/*
	 * add action listener for each of XOGameButton
	 */
	public void addListeners(){
		XOGameButton[][] buttonArray = gameField.getJb();
		for(int i=0;i<buttonArray.length;i++){
			for(int j=0;j<buttonArray[i].length;j++){
				buttonArray[i][j].addActionListener(this);
			}
		}
	}
	
	/*
	 * make computer move
	 */
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
