package java5;

public class Cat extends Animal{
	public Cat(){
		super();// обязательно создаем предка
	}
	
	@Override
	void voice(){
		System.out.println("mew");
	}
}
// пустой класс без ничего УЖЕ содержит пустой конструктор