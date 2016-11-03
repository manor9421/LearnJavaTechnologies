package javaBeans_plus;

public class Main1 {

	public static void main(String[] args) throws InterruptedException {
		
		TaskManager tm = new TaskManager();
		Client client1 = new Client("Delete All");
		Client client2 = new Client("Read DB");
				
		
		tm.addTaskListener(client1);
		tm.addTaskListener(client2);
		tm.addTaskListener(client2);
		
		tm.works();
		
		
		tm.removeTaskListener(client1);
		tm.removeTaskListener(client2);
		tm.removeTaskListener(client2);
		
	}

}
