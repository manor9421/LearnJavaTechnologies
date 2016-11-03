package com.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.mnr.animals.Bird;

@SpringBootApplication
public class LittleSpringProjApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		
		Object obj = context.getBean("Bird");
		
		if(obj instanceof Bird){
			Bird bird = (Bird) context.getBean("Bird");
			bird.fly();
		}
	}
}
