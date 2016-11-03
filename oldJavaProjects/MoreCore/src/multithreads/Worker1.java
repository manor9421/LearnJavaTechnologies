package multithreads;

public class Worker1 extends Thread{
	private int id;
	private Data2 data;
	
	public Worker1(int id, Data2 d){
		this.id = id;
		this.data = d;
		
		this.start();// сразу стартуем поток
	}
	
	@Override
	public void run() {
		//super.run();
		synchronized (data) {
			for (int i = 0; i < 5; i++) {
				try{
					while(id != data.getState()) data.wait();// усыпить тот, что с data
						if(id==1) data.tic();
						else data.tak();
						
						data.notify();// разбудить тот, что с data
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
