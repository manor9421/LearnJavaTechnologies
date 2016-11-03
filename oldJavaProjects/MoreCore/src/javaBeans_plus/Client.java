package javaBeans_plus;

public class Client implements TaskMListener{

	private String name;
	
	
	public Client(String name) {
		this.name = name;
		//thread.start();
	}


	@Override
	public void start(TaskData ev) {
		System.out.println("Start: "+name+" "+ev.getDate());
	}


	@Override
	public void stop(TaskData ev) {
		System.out.println("Stop: "+name+" "+ev.getDate());
	}
	
}
