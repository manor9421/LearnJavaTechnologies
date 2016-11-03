package ru.javabegin.training.spring.aop.loggins;
import java.util.Map;
import java.util.Set;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect//определить как аспект(чтобы не писать в xml. Component обязательно)
public class MyLogger {

	/*public void printValue(Object obj) {
		System.out.println(obj);
	}

	public void init() {
		System.out.println("init");
	}

	public void close() {
		System.out.println("close");
	}*/
	
	
	//@Pointcut("execution(* *(..)) && within(ru.javabegin.training.spring.aop.objects.*)")//объявляем Поинткат.
	@Pointcut("execution(* ru.javabegin.training.spring.aop.objects.Manager.*(..))")//в этот срез попадут только те методы, которые реализуют данный интерфейс
	private void allMethods(){//этот метод раньше создавался в XML, но раз без него - создаем пустой
	}
	
	// два вида аннотаций - allMethods() и наша ShowTime
	//@Around("allMethods() && @annotation(ru.javabegin.training.spring.aop.annotations.ShowTime)")
	@Around("allMethods() && execution(java.util.Map *(..))")//попадут все методы из Manager и Map
	public Object watchTime(ProceedingJoinPoint joinpoint) {//принимает ссылку на текущий join point
		long start = System.currentTimeMillis();
		System.out.println("method begin: " + joinpoint.getSignature().toShortString());
		Object output = null;
		/*try {
			output = joinpoint.proceed();*/
		for (Object object : joinpoint.getArgs()) {
			System.out.println("Param : " + object);
		}

		try {
				output = joinpoint.proceed(new Object[] { "/home" });
		} catch (Throwable e) {
			e.printStackTrace();
		}

		long time = System.currentTimeMillis() - start;
		System.out.println("method end: " + joinpoint.getSignature().toShortString() + ", time=" + time + " ms");

		return output;
	}

	@SuppressWarnings("rawtypes")//не показывать сообщение данного типа(при компиляции)
	@AfterReturning(pointcut = "allMethods()", returning = "obj")
	public void print(Object obj) {

		System.out.println("Print info begin >>");

		if (obj instanceof Set) {
			Set set = (Set) obj;
			for (Object object : set) {
				System.out.println(object);
			}

		} else if (obj instanceof Map) {
			Map map = (Map) obj;
			for (Object object : map.keySet()) {
				System.out.println("key=" + object + ", " + map.get(object));
			}
		}

		System.out.println("Print info end <<");
		System.out.println();
	}
	
	@SuppressWarnings("rawtypes")
	@AfterReturning(pointcut = "allMethods() && execution(java.util.Set *(String)) && args(folder)", returning = "obj")//folder - что придЁт в метод
	public void printSet(Object obj, String folder) {

		System.out.println("Printing set >>");
		System.out.println("Folder = " + folder);
		Set set = (Set) obj;
		for (Object object : set) {
			System.out.println(object);
		}
		System.out.println("End printing set <<");
		System.out.println();

	}
	
}