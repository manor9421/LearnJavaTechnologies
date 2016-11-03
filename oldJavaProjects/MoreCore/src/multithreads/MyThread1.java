package multithreads;

public class MyThread1 extends Thread {

@Override
	public void run()
	{
	for (int i = 0; i < 30; i++)
		System.out.println("Name = " + Thread.currentThread().getName() +
				", i = " + i);
	}

}
