package threads;

import java.io.IOException;

public class Main3 {
	
	volatile public static boolean flag = true;
	
	public static class ThreadFlagSetter extends Thread{ // implements Runnable
		@Override
		public void run() {
			try{
			int k = System.in.read();
			}catch (IOException e) {
				e.printStackTrace();
			}
			flag = false;
			System.err.println("Flag was set to " + flag);
			
		}
	}
	
	public static class ThreadFlagReader extends Thread{ // implements Runnable
		@Override
		public void run() {
			while(flag){}
			System.err.println("ThreadFlagReader completed!");
		}
	}

	public static void main(String[] args) {
		
		new ThreadFlagSetter().start();
		new ThreadFlagReader().start();
		
	}

}
