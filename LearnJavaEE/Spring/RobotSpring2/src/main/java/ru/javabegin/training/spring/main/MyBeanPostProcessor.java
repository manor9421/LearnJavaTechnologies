package ru.javabegin.training.spring.main;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

// сюда будут попадать ВСЕ!!!! создаваемые бины. из context.xml нужно убрать init
// и destroy методы(т.к. уде не нужны) и объявить этот класс, как бин
public class MyBeanPostProcessor implements BeanPostProcessor {

	//после инициализации
	@Override
	public Object postProcessAfterInitialization(Object object, String name) throws BeansException {

		return object;
	}
	
	//до инициализации
	@Override
	public Object postProcessBeforeInitialization(Object object, String name) throws BeansException {
		System.out.println(object + " - postProcessBeforeInitialization()");
		return object;
	}

}