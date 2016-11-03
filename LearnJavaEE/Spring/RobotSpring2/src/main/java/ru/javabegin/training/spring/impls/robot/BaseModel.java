package ru.javabegin.training.spring.impls.robot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

import ru.javabegin.training.spring.interfaces.Hand;
import ru.javabegin.training.spring.interfaces.Head;
import ru.javabegin.training.spring.interfaces.Leg;
import ru.javabegin.training.spring.interfaces.Robot;

public abstract class BaseModel implements Robot {

	@Autowired // автоматическое связывание
	@Qualifier("sonyHand") // связывать по имени(именно с sonyHand(qualifier ИЛИ айди бина в Spring). если у sonyHand autowifed=false - не свяжет и будет ошибка)
	private Hand hand;
	
	
	@Autowired(required=false) // если найдет что связать - свяжет. Если нет - ничего страшного, без ошибки автосвязывания
	@Qualifier("sonyLeg")
	private Leg leg;
	
	@Autowired
	@Qualifier("sonyGoldenHead")
	private Head head;

	public BaseModel() {
		System.out.println(this + " - BaseModel constructor()");
	}

	/*
	 * Т.к. @Qualifier стоит, то нам можно не пользлваться конструктором,
	 * потому что эти переменные и так обязательно нужно заполнить
	 */
	public BaseModel(Hand hand, Leg leg, Head head) {
		this();
		this.hand = hand;
		this.leg = leg;
		this.head = head;
	}

	public Hand getHand() {
		return hand;
	}
	
	@Required // обозначаем, что этот сеттер обязателен. Чтобы при
		//сборке бина была ошибка при отсутствии этого сеттера
	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public Leg getLeg() {
		return leg;
	}
	@Required
	public void setLeg(Leg leg) {
		this.leg = leg;
	}

	public Head getHead() {
		return head;
	}
	@Required
	public void setHead(Head head) {
		this.head = head;
	}

}