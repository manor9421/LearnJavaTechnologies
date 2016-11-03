package com.mnr.xo.interfaces;

import com.mnr.xo.controller.Controller;

public interface XOGameButton {

	public int getI();

	public int getJ();
	
	public void setText(String text);

	public void addActionListener(Controller controller);
	
}
