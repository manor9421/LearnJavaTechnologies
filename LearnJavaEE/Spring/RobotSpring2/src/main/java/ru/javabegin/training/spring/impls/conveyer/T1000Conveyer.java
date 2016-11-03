package ru.javabegin.training.spring.impls.conveyer;

import ru.javabegin.training.spring.interfaces.Robot;
import ru.javabegin.training.spring.interfaces.RobotConveyor;

public abstract class T1000Conveyer implements RobotConveyor {

	@Override
	public abstract Robot createRobot();
	
}
