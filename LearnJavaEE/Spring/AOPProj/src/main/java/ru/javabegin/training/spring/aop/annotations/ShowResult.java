package ru.javabegin.training.spring.aop.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//создаем свою аннотацию
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ShowResult {

}
