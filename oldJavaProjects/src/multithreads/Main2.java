package multithreads;


class Data
{
    int count =0;
    static int countSt =0;
}

class MyThread2 implements Runnable {
  
    Data obj;
    
    private static final Object synk = new Object();
    
    MyThread2(Data d){
        obj = d;
        new Thread(this).start();
    }
    /*
    synchronized void Add(){
        try {
            Thread.sleep(10);
            int n=obj.count;
            n++;
            Thread.sleep(10);
            obj.count=n;
        } catch (InterruptedException ex) {       }
    }
    synchronized static void AddStatic() {
                try {
            Thread.sleep(10);
            int n=Data.countSt;
            n++;
            Thread.sleep(10);
            Data.countSt=n;
        } catch (InterruptedException ex) {       }
    }*/
    
    void Add(){
        try {
        	Thread.sleep(10);
        	
        	synchronized (obj) {
                int n=obj.count;
                n++;
                Thread.sleep(10);
                obj.count=n;
			}
        } catch (InterruptedException ex) {       }
    }
    static void AddStatic() {
        try {
        	Thread.sleep(10);
        	
        	synchronized (synk) {
                int n=Data.countSt;
                n++;
                Thread.sleep(10);
                Data.countSt=n;
			}
        } catch (InterruptedException ex) {       }
    }
    
    public void run() {
        for(int i=0; i<10; i++) Add();
        for(int i=0; i<10; i++) AddStatic();
    }
    /*
     * wait(время);// ждать некоторое время
    while(!ready) wait(); // ждать (только для СИНХРОНИЗИРОВАННЫХ)
    notify(); // пробудить первого в очередии, кто ждет
    notifyAll();// пробудить всех - НЕ потокобезопасно
    
    IllegalMonitorStateException - ошибка, если спит один поток, а мы будим другой
    */
}

public class Main2 {

    public static void main(String[] args) throws Exception {
    	
        Data d=new Data();
        MyThread2 t1=new MyThread2(d);
        MyThread2 t2=new MyThread2(d);

        Thread.sleep(1000);
        System.out.println(d.count);
        System.out.println(Data.countSt);    }

}
