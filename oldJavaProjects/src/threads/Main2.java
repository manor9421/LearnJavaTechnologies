package threads;


public class Main2 {

	public static class Jamy extends Thread{ // implements Runnable
		@Override
		public void run() {
			for (int i = 0; i < 60; i++) {
				System.out.println(i+" "+Thread.currentThread());
			}
		}
	}
	
	public static void main(String[] args) {
		Jamy recipe = new Jamy();
		Thread thread = new Thread(recipe);
		thread.start();
	}

}
