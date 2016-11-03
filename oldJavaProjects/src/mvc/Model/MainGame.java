package mvc.Model;

public class MainGame {

	public static Field field = new Field();
	public static Computer computer = new Computer();
	public static User user = new User();
	
	//public static void main(String[] args) {
	public static void start(){
		//field.doShoot(new Point(2, 2), Field.GameType.X);
		field.show();
		for(int i=0;i<10;i++){
			field.doShoot(computer.getShoot(), Field.GameType.X);
			field.show();
			boolean result = field.checkWin(Field.GameType.X);
			if(result){
				System.out.printf("X wins!");
				break;
			}
			
			field.doShoot(user.getShoot(), Field.GameType.O);
			field.show();
			result = field.checkWin(Field.GameType.O);
			if(result){
				System.out.printf("O wins!");
				break;
			}
		}
		
	}
}
