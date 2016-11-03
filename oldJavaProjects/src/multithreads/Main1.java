package multithreads;

public class Main1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		final MyThread1 mt = new MyThread1();
		CanCancelThread omt = new CanCancelThread();
		
		mt.setDaemon(true);// сделать демоном. Должен завершатся только виртуальной машиной. Принудительно!!!
		// как службы - низкий приоритет
		System.out.println(mt.isDaemon());
		mt.start();
		omt.thread.start();
                
//		new Thread() {
//@Override public void run()
//			{
//				for (int i = 0; i < 30; i++)
//					System.out.println("Name = " + Thread.currentThread().getName() +
//							", i = " + i);
//			}
//		}.start();

		mt.join();// ждать, пока не завершиться mt
		//omt.thread.join();
		
		Thread.sleep(10);// можно только для текущего потока вызвать
		
		omt.thread.interrupt();// Если другой поток выполняет прерываемый метод блокирования низкого уровня, такой как Thread.sleep(), Thread.join() или Object.wait(), то он разблокируется и выдает InterruptedException. Иначе, interrupt() просто устанавливает статус прерывания потока.
		omt.cancel = true;
                
                System.out.println("end of main");
	}

}
/*
Если в потоке будет эксепшн - вылетит поток

Методы suspend,resume.stop - DEPRECATED
*/

/*
MyThread a = new MyThread();
MyThread b= new MyThread();

ThreadGroup gr = new ThreadGroup(“name");// группа потоков(для общего управления)

Thread t1= new Thread(gr, a, “Thread #1");
Thread t2= new Thread(gr, b, “Thread #2");
t1.start();
t2.start();

Thread threads[] = new Thread[gr.activeCount()];
gr.enumerate(threads);
for(Thread t : threads)
	System.out.println(t.getName());
gr.interrupt(); 
*/