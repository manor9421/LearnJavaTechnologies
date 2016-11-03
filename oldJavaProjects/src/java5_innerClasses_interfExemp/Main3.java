package java5_innerClasses_interfExemp;

public class Main3 {

	public static void main(String[] args) {
		
		// экземпляр потомка от Flyable
		Flyable anon = new Flyable(){

			@Override
			public void fly() {
				System.out.println("Woooooh!!!!");
			}
		};
		
		//Rocket rocket = new Rocket();
		/*
		массив экземпляров интерфейсов 
		*/
		Flyable[] flyables = new Flyable[3];
		for(int i=0;i<flyables.length;i++){
			flyables[i] = anon;
		}
		
		for(Flyable flyable : flyables){
			flyable.fly();
		}
	}
}
