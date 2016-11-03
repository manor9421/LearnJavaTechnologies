package java5_innerClasses_interfExemp;

public class Main4 {

	static int a;
	public static void main(String[] args) {
		
		Flyable[] flyables = new Flyable[3];
		for(int i=0;i<flyables.length;i++){

			final int finalI = i;// чтобы было доступно во внутреннем классе
			
			flyables[i] = new Flyable() {
				@Override
				public void fly() {
					System.out.println("I'm flying" + finalI + a);
				}
			};
		}
		
		for(Flyable flyable : flyables){
			flyable.fly();
		}
	}

}
