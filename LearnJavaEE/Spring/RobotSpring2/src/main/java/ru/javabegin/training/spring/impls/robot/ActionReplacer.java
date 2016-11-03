package ru.javabegin.training.spring.impls.robot;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class ActionReplacer implements MethodReplacer {

	@Override
	public Object reimplement(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		// что делает
		System.out.println("new action!");
		return null;
	}

}