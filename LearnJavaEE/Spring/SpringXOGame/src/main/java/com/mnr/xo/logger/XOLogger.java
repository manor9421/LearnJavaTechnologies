package com.mnr.xo.logger;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//import org.aspectj.lang.annotation.Aspect;

@Component
@Aspect
public class XOLogger {
	
	public XOLogger(){
	}
	
	
	@AfterReturning(pointcut = "execution(* com.mnr.xo.model.Game.getGameFieldSymbol(..))", returning = "obj")
	public void printReturnedValue(Object obj) {
		System.out.println("Button Symbol is: " + obj);
	}
	
	@Before("execution(* com.mnr.xo.view.GameField.changeButtonText(..))")
	public void buttonStartChange() {
		System.out.println("Button start changed");
	}

	@After("execution(* com.mnr.xo.view.GameField.changeButtonText(..))")
	public void buttonChanged() {
		System.out.println("Button changed");
	}
	
	@AfterReturning(pointcut = "execution(* com.mnr.xo.model.Game.isWinner())", returning = "obj")
	public void checkWinner(Object obj) {
		if(obj.toString() != "EMPTY"){
			System.out.println("We have a winner");	
		}
	}
}
