package mvc;

import mvc.Model.MainGame;
import mvc.View.GameWindow;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameWindow gameWindow = new GameWindow();
		gameWindow.init();
		MainGame.start();
	}

}
