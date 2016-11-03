package com.mnr.xo.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.mnr.xo.interfaces.XOGameButton;
import com.mnr.xo.interfaces.XOGameViewField;
import com.mnr.xo.model.PlayerSymbol;
import com.mnr.xo.model.GameButton;

@Component//create Bean gameField
//@Qualifier(value="gameField")
@Lazy
public class GameField implements XOGameViewField {


	private JFrame mainWindow;
	private XOGameButton[][] jb;// = new XOGameButton[3][3];
	
	
	public GameField() {
		mainWindow = new JFrame("XO Game");
		jb = new GameButton[3][3];
		for(int i=0;i<jb.length;i++){
			for(int j=0;j<jb[i].length;j++){
				jb[i][j] = new GameButton(i,j,"-");
				mainWindow.add((GameButton)jb[i][j]);
			}
		}
	}
	
	//@Bean
	public GameField gameField(){
		return new GameField();
	}

	@Override
	public XOGameButton[][] getJb() {
		return jb;
	}

	@Override
	public void setJb(XOGameButton[][] jb) {
		this.jb = jb;
	}

	//отрисовать поле
	@Override
	public void drawField(){
		mainWindow.setSize(400,300);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setVisible(true);
		mainWindow.setLayout(new GridLayout(0,3));
		for(int i=0;i<jb.length;i++){
			for(int j=0;j<jb[i].length;j++){
				//jb[i][j] = new XOGameButton(i,j,"-");
				
				mainWindow.add((GameButton)jb[i][j]);
			}
		}
	}
	
	//congrats message
	@Override
	public void informWinner(String name){
		mainWindow.getContentPane().removeAll();
		mainWindow.setLayout(new BorderLayout());
		JLabel jl = new JLabel("Congratulation!!! " + name + ", you WIN!");
		//mw.repaint();
		mainWindow.add(jl,BorderLayout.CENTER);
	}
	
	@Override
	public void changeButtonText(int i,int j,PlayerSymbol symbol){
		jb[i][j].setText(symbol+"");
	}
}
