package javaBeans_plus;

import java.util.Calendar;
import java.util.EventObject;

public class TaskData extends EventObject{
	private String name;
	private String date;
	
	public TaskData(Object source, String name) {
		super(source);
		this.name = name;
		this.date = Calendar.getInstance().getTime().toString();
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
