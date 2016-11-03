package ru.javabegin.training.spring.interfaces;

import java.util.Collection;

public interface RobotPool {

	Collection<Robot> getRobotCollection();

	// для Map
	//Map<String, Robot> getRobotCollection();
	
}