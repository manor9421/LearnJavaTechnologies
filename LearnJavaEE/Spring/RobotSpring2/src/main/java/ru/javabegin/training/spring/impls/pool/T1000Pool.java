package ru.javabegin.training.spring.impls.pool;

import java.util.Collection;

import ru.javabegin.training.spring.interfaces.Robot;
import ru.javabegin.training.spring.interfaces.RobotPool;

public class T1000Pool implements RobotPool {

	private Collection<Robot> robotCollection;

	public void setRobotCollection(Collection<Robot> robotCollection) {
		this.robotCollection = robotCollection;
	}

	@Override
	public Collection<Robot> getRobotCollection() {
		return robotCollection;
	}

	public void action() {
		for (Robot robot : robotCollection) {
			robot.action();
		}
	}
	
	//для Map
	/*private Map<String, Robot> robotCollection;

	public T1000Pool(Map<String, Robot> robotCollection) {
		super();
		this.robotCollection = robotCollection;
	}

	@Override
	public Map<String, Robot> getRobotCollection() {
		return robotCollection;
	}

	public void action() {

		for (Map.Entry<String, Robot> entry : robotCollection.entrySet()) {
			System.out.println(entry.getKey());
			entry.getValue().action();
		}

	}*/
	
	public void beginShow() {
		for (Robot robot : robotCollection) {
			robot.action();
		}
	}

}