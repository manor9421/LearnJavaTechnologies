package multithreads;

public class Data2 {

	private int state = 1;

    public int getState() { return state; }

    public void tic(){
        System.out.print("Tic-");
        state=2;
    }
    public void tak(){
        System.out.println("Tak");
        state=1;
    }
}
