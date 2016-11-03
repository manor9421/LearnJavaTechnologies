package threads;

public class Main {
	
	public static class Recipe implements Runnable{
		void cook(){
			System.out.println("...");
		}

		@Override
		public void run() {
			cook();
			for (int i = 0; i < 60; i++) {
				System.out.println("..." + i + " " + Thread.currentThread());// получить данный поток
			}
		}
	}
	
	public static void main(String[] args) {
		
		Recipe recipe = new Recipe();
		
		Thread thread = new Thread(recipe);
		thread.start();// после выполнения поток остановится сам.
		// Еще один .start() ничего не сделает. Нужно заново еще раз создавать элемент
		
		new Thread(new Recipe()).start();// 3-й поток
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		}).start();// 4-й поток
		
		new Thread(new Recipe()).start();

		System.out.println("main thread....");
		
	}
}
