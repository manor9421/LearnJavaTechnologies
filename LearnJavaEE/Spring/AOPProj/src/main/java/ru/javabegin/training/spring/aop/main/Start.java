package ru.javabegin.training.spring.aop.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.javabegin.training.spring.aop.objects.SomeService;

import ru.javabegin.training.spring.aop.objects.FileManager;
import ru.javabegin.training.spring.aop.objects.FileManager2;

public class Start {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		/*SomeService service = (SomeService) context.getBean("someService");
		double val = service.getDoubleValue();*/
		
		/*FileManager fileUtil = (FileManager) context.getBean("fileManager");
		fileUtil.getExtensionCount("/home");
		fileUtil.getExtensionList("/home/manor9421/Downloads");*/
		
		FileManager fileManager = (FileManager) context.getBean("fileManager");
		FileManager2 fileManager2 = (FileManager2) context.getBean("fileManager2");
		fileManager.getExtensionCount("/home");
		//fileManager.getExtensionCount("/lib");
		//fileManager.getExtensionCount("/srv");
		fileManager.getExtensionList("/var");

		fileManager2.getExtensionCount("/home");// методы fileManager2 не попадают в срез, так что вызваны не будут

	}
}