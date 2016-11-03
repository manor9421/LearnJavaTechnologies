package multithreads;

import java.util.Random;

public class ThreadLocalClass {

	// записываем значение во внутреннюю память потока
	private static ThreadLocal<Integer> threadLocal =
    	new ThreadLocal<Integer>()
    	{
        @Override
        	protected Integer initialValue()
        	{
        		return new Random().nextInt(100);
        	}
    	};

    public static void main(String[] args) {
                threadLocal.set(new Random().nextInt(100));
		Runnable runner = new Runnable()
		{
                    public void run()
                    {
                        threadLocal.set(new Random().nextInt(100));
              	        System.out.println("Thread " +
                                Thread.currentThread().getName() + ", value is " + threadLocal.get());
                }
		};

		for (int i=0; i<3; i++)
			(new Thread (runner)).start();

		System.out.println("Main Thread, value is " +	threadLocal.get());
	}
}
