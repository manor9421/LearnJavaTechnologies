package multithreads;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServicesMain {

    public static void main(String[] args) throws Exception {
        new Data3().solve();
    }

}
class Data3 {
    public void solve() throws Exception
    {
            List<Future<String>> list =
                    new ArrayList<Future<String>>();

            ExecutorService es = Executors.newFixedThreadPool(5);// ограничение на 5 потоков
            for (int i = 0; i < 7; i++)
                    list.add(es.submit(new MyCallable<String>()));

            es.shutdown();// освободить пул потоков
            //es.shutdownNow();// закрыть немедленно. Но если задач будет больше, чем потоков - можно нарваться на ошибку(обращение к закрытому потоку)

            for (Future<String> f : list)
                    System.out.println(f.get());
    }
}
class MyCallable<T> implements Callable {

	@Override
	public T call() throws Exception {

		String res = Thread.currentThread().getName();
                Thread.sleep(1000);
                System.out.println("done");
		return (T)res;
	}
}

/*
es.awaitTermination(5000, TimeUnit.MILLISECONDS);

readlock/writelock...
w1.unlock();
*/
