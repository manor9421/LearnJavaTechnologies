package multithreads;

public class CanCancelThread implements Runnable {
	public Thread thread;
	
	public volatile boolean cancel = false;//volatile потому что если cancel нигде не используется в классе, и внутри него ВСЕГДА имеет дефолтное значение, то компилятор может его вообще выбросить. Так что мы указываем, что НЕ нужно оптимизировать эту часть кода

	public CanCancelThread()
	{
		thread = new Thread(this);
	}

	@Override
	public void run() {
		try{
			double d = 1.1;
			for (int i = 0; i < 30; i++){
				//if(cancel) return;// завершить поток
				if(cancel) throw new InterruptedException();// ТОЖЕ завершить поток, но выбросив ошибку, которую ниже обработаем
				
				for(int j=0;j<10000;j++) d=d*d;
				
				System.out.println("Name = " + Thread.currentThread().getName() +
						", i = " + i);
			}
		}catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}
