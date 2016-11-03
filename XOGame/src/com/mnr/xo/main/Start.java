package com.mnr.xo.main;

import com.mnr.xo.controller.Controller;
import com.mnr.xo.model.Game;
import com.mnr.xo.model.Player;
import com.mnr.xo.model.PlayerSymbol;
import com.mnr.xo.view.GameField;

public class Start {

	public static void main(String[] args) {
		// создаем окно
		GameField gameField = new GameField();
		gameField.drawField();

		Player player = new Player(PlayerSymbol.X, "Sergey");
		Game game = new Game();
		
		new Controller(gameField,game,player);
		
	}

}
