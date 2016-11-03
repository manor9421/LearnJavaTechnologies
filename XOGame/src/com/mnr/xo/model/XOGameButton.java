package com.mnr.xo.model;

import javax.swing.JButton;

public class XOGameButton extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int i;
	int j;
	
	public XOGameButton(int i, int j, String text) {
		super();
		this.i = i;
		this.j = j;
		this.setText(text);
	}

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}
	
	
	
	
}
