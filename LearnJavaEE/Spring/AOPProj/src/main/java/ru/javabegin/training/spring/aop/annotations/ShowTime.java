package ru.javabegin.training.spring.aop.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)// когда будет выполняться
@Target(ElementType.METHOD)// к чему будет применяться
public @interface ShowTime {

}
