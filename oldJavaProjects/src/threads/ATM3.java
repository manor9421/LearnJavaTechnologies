package threads;

public class ATM3 {

	static int money = 100;

	static Object key = new Object();// создаем ключ, можно любой тип
	
	synchronized static void getMoney(int amount){//как только 1-й(поток) взял ключ - никто не может воспользоваться этим методом, пока он его не вернет
		synchronized (key) { // разрешить доступ к этому блоку только по ключу
			// первый, кто заше - взял ключ. Остальные ждут, пока он его не вернет
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
			/*
			// усыпить по ключу
			try {
				key.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//разбудить ВСЕХ по ключу - у кого этот ключ)
			synchronized (key) {
				key.notufyAll();
			}
			*/
		}
		System.err.println("out of synchronized block");
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
