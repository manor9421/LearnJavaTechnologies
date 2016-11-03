package multithreads;

public class TictakMain {
	public static void main(String[] args) throws InterruptedException{
		Data2 d = new Data2();
		
        Worker1 w1 = new Worker1(1, d);
        Worker1 w2 = new Worker1(2, d);

        w1.join();// ждать, пока не завершиться w1
        w2.join();
        System.out.println("end of mian...");
	}
}
