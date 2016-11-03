package ru.javabegin.training.spring.impls.robot;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.javabegin.training.spring.interfaces.Hand;
import ru.javabegin.training.spring.interfaces.Head;
import ru.javabegin.training.spring.interfaces.Leg;
import ru.javabegin.training.spring.interfaces.Robot;

/*
 * Скачать аннотации - Preferences - Maven и поставить галочки Artifacts и Javadoc
 * Еще есть @Lazy
 */

@Component // этот класс превратиться в бин автоматически, ЕСЛИ его будет искать спринг(<context:annotation-config...)
//@Qualifier(value="model1")
public class ModelT1000 extends BaseModel implements Robot,InitializingBean,DisposableBean {

	/*private Hand hand;
	private Leg leg;
	private Head head;*/

	private String color;
	private int year;
	private boolean soundEnabled;

	public ModelT1000() {
	}
	
	@Bean// автоматически станет бином
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)// указываем scope
	public ModelT1000 model1(){
		return new ModelT1000();//
	}

	@Bean// автоматически станет бином
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)// указываем scope
	public ModelT1000 model2(){
		return new ModelT1000();//
	}
	
	/*public ModelT1000(Hand hand, Leg leg, Head head) {
		super();
		this.hand = hand;
		this.leg = leg;
		this.head = head;
	}*/
	public ModelT1000(Hand hand, Leg leg, Head head) {
		super(hand, leg, head);
	}
	
	/*public ModelT1000(Hand hand, Leg leg, Head head, String color, int year, boolean soundEnabled) {
		super();
		this.hand = hand;
		this.leg = leg;
		this.head = head;
		this.color = color;
		this.year = year;
		this.soundEnabled = soundEnabled;
	}*/
	public ModelT1000(Hand hand, Leg leg, Head head, String color, int year, boolean soundEnabled) {
		super(hand, leg, head);
		this.color = color;
		this.year = year;
		this.soundEnabled = soundEnabled;
	}

	public ModelT1000(String color, int year, boolean soundEnabled) {
		super();
		this.color = color;
		this.year = year;
		this.soundEnabled = soundEnabled;
	}

	@Override
	public void action() {
		getHead().calc();
		getHand().catchSomething();
		getLeg().go();
		System.out.println("color: " + color);
		System.out.println("year: " + year);
		System.out.println("can play sound: " + soundEnabled);
	}

	@Override
	public void dance() {
		System.out.println("T1000 is dancing!");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean isSoundEnabled() {
		return soundEnabled;
	}

	public void setSoundEnabled(boolean soundEnabled) {
		this.soundEnabled = soundEnabled;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println(this + " - method destroy()");

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(this + " - method init()");

	}

	public void initObject(){
		System.out.println("init");
	}
	
	public void destroyObject(){
		System.out.println("destroy");
	}

}
