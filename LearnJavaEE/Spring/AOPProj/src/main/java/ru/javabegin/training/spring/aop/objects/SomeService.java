package ru.javabegin.training.spring.aop.objects;

import org.springframework.stereotype.Component;

@Component // автоматически подключаем бины в контейнер
public class SomeService {

	public int getIntValue() {
		return 5;
	}

	public double getDoubleValue() {
		return 5.6;
	}

}