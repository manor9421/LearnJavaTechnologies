package javaBeans_plus;

import java.util.EventListener;

public interface TaskMListener extends EventListener{
	public void start(TaskData ev);
	public void stop(TaskData ev);
	
}
