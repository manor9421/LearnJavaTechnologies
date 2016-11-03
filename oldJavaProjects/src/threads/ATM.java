package threads;

public class ATM {
	
	static int money = 100;
	
	static void getMoney(int amount){
		if(amount <= money){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			money -= amount;
			System.err.println("All OK! New amount: " + money);
		}else{
			System.err.println("Not enough");
		}
	}

	public static void main(String[] args) {

		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.err.println("Me");
				getMoney(50);
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.err.println("Bob");
				getMoney(50);
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.err.println("John");
				getMoney(50);
			}
		}).start();

	}

}
