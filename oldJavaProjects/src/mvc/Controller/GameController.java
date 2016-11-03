package mvc.Controller;

import mvc.Model.Field;
import mvc.Model.Point;
import mvc.Model.User;

public class GameController {

	public static void doShoot(Point point, Field.GameType type){
		User.point = point;
		User.isShoot = true;
		
		
	}
}
