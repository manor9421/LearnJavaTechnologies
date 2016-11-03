package multithreads;

public class Main3 extends Thread {

	private boolean suspended = false;
	private boolean terminated = false;

	public Main3(){
		suspended = false;
		terminated = false;
	}
	public Main3 (boolean susp){
		suspended = susp;
		terminated = false;
	}
	public void terminate (){
		terminated = true;
	}
	public void my_suspend (){
		if (!suspended)
		{
			suspended = true;
		}
	}
	public void my_resume (){
		if (suspended)
		{
			suspended = false;
			synchronized(this)
			{
				notify();
			}
                        System.out.print("go....");
		}
	}
	public boolean is_suspended()	{
		return suspended;
	}

@Override
	public void run(){
            int count = 0;
            try
            {
                    while (!terminated)
                    {
                            synchronized (this)
                            {
                                    while (suspended)	wait();
                            }
                            System.out.println ("Count = " + count++);
                            Thread.sleep(100);
                    }
            }
            catch (InterruptedException e)
            {
                    e.printStackTrace();
            }
	}

	public static void main(String[] args) throws Exception {

		Main3 thr = new Main3();
		thr.start();

                for(int i=0; i<3; i++) {
                    Thread.sleep(1000);
                    if (thr.is_suspended())
				thr.my_resume();
		    else
				thr.my_suspend();
                }
		thr.my_resume();
		thr.terminate();

		thr.join();

	}

}
