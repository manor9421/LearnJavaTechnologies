package mvc.Model;

public class User {
	public static Point point;
	public volatile static boolean isShoot;//обновлять переменную моментально, не кэшируя
	
	public Point getShoot(){
		//return Point.getRandomPoint();
		isShoot = false;
		while(!isShoot);// вечный цикл, пока не выиграем
		return point;
		
	}
}
