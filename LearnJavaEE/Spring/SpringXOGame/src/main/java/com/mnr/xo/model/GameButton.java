package com.mnr.xo.model;

import javax.swing.JButton;

import com.mnr.xo.controller.Controller;
import com.mnr.xo.interfaces.XOGameButton;

public class GameButton extends JButton implements XOGameButton{

	private static final long serialVersionUID = 1L;

	private int i;
	private int j;
	
	public GameButton(int i, int j, String text) {
		super();
		this.i = i;
		this.j = j;
		this.setText(text);
	}

	@Override
	public int getI() {
		return i;
	}

	@Override
	public int getJ() {
		return j;
	}
	
	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		super.setText(text);
	}

	@Override
	public void addActionListener(Controller controller) {
		super.addActionListener(controller);
	}
	
	
}
