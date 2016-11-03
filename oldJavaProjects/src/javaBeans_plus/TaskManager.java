package javaBeans_plus;

import java.util.*;

public class TaskManager {
	ArrayList<TaskMListener> list = new ArrayList<>();// не потокобезопасная коллекция
	
	public void works() throws InterruptedException{
		Random random = new Random();
		
		Thread.sleep(random.nextInt(2000));
		fireTask(1,"");
		Thread.sleep(random.nextInt(4000));
		fireTask(2, "");
	}
	
	public synchronized void addTaskListener(TaskMListener tl){
		list.add(tl);
	}
	
	public synchronized void removeTaskListener(TaskMListener tl){
		list.remove(tl);
	}
	
	private void fireTask(int eventId, String name){
		ArrayList<TaskMListener> copy;
		
		synchronized (this) {// синхрон по this
			copy = (ArrayList<TaskMListener>) list.clone();
		}
		
		TaskData ev = new TaskData(this, name);
		
		for (TaskMListener tl : copy) {
			if(eventId == 1){
				tl.start(ev);
			}else {
				tl.stop(ev);
			}
		}
	}
	
}
