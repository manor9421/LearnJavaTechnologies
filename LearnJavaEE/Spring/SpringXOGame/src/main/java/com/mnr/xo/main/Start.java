package com.mnr.xo.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mnr.xo.controller.Controller;
import com.mnr.xo.view.GameField;

public class Start {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("AppContext.xml");
		
		GameField gameField = (GameField) context.getBean("gameField");
		gameField.drawField();
		
		Controller controller = (Controller) context.getBean("controller");
		controller.addListeners();
		
		//close context variable
		((ClassPathXmlApplicationContext) context).close();
		
	}

}
