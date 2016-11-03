package java5_abstract_interface;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cat cat= new Cat();
		
		Animal animal = new Cat();//в памяти - Cat, но
		// его методы - только те, что есть у Animal,
		// без своих (переопределенные - переопределены)
		
		
	}

}
