package java5_abstract_interface;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		массив экземпляров интерфейсов 
		*/
		Flyable[] flyables = new Flyable[3];
		for(int i=0;i<flyables.length;i++){
			flyables[i] = new Duck();
		}
		
		for(Flyable flyable : flyables){
			flyable.fly();
		}
	}

}
