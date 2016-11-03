package java5_innerClasses_interfExemp;


public class Main2 {

	public static void main(String[] args) {
		
		class Rocket implements Flyable{//внутренний класс

			@Override
			public void fly() {
				System.out.println("Shhhh!!!!");
			}
			
		}
		
		
		
		
		//Rocket rocket = new Rocket();
		/*
		массив экземпляров интерфейсов 
		*/
		Flyable[] flyables = new Flyable[3];
		for(int i=0;i<flyables.length;i++){
			flyables[i] = new Rocket();
		}
		
		for(Flyable flyable : flyables){
			flyable.fly();
		}
	}

}
