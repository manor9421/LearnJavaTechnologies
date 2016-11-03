package ru.javabegin.training.spring.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.javabegin.training.spring.impls.pool.T1000Pool;
import ru.javabegin.training.spring.impls.robot.ModelT1000;
import ru.javabegin.training.spring.interfaces.Robot;
import ru.javabegin.training.spring.interfaces.RobotConveyor;

public class Start {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		/*Object obj = context.getBean("t1000");
		
		if(obj instanceof ModelT1000){
			ModelT1000 t1000 = (ModelT1000) context.getBean("t1000");
			t1000.action();
			
			System.out.println(t1000);
			
			t1000 = (ModelT1000) context.getBean("t1000");
			System.out.println(t1000);
		}	*/
			
		/*RobotConveyor t1000Conveyor = (RobotConveyor) context.getBean("t1000Conveyor");

		Robot terminator1 = t1000Conveyor.createRobot();
		Robot terminator2 = t1000Conveyor.createRobot();
		Robot terminator3 = t1000Conveyor.createRobot();

		System.out.println("terminator1 " + terminator1);
		System.out.println("terminator2 " + terminator2);
		System.out.println("terminator3 " + terminator3);
		*/
		
		/*T1000Pool t1000Pool = (T1000Pool) context.getBean("t1000Pool");
		t1000Pool.action();*/
		
		/*T1000Pool t1000GoldenPool = (T1000Pool) context.getBean("t1000ColdenPool");
		t1000GoldenPool.beginShow();
		*/
		
		ModelT1000 model1 = (ModelT1000) context.getBean("model1");// получаем бин с qualifier "model1"
		ModelT1000 model2 = (ModelT1000) context.getBean("model2");
		model1.action();
		model2.action();
		System.out.println(model1);
		
	}
}
